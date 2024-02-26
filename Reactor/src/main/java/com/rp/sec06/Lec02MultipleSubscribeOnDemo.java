package com.rp.sec06;

import courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec02MultipleSubscribeOnDemo {

    public static void main(String[] args) {

        Flux<Object> flux = Flux.create(fluxSink -> {
            printThreadName("create");
            fluxSink.next(1);
        })
                // subscribeon which is closer to publisher will take precedence
                // because consumers don't know the complexity of publisher and may choose a wrong scheduler
                // so it is responsibility of publisher to choose right scheduler
                .subscribeOn(Schedulers.newParallel("vins"))
                .doOnNext(i -> printThreadName("next " + i));

        Runnable runnable = () -> flux.
                doFirst(() -> printThreadName("first2"))
                .subscribeOn(Schedulers.boundedElastic())
                .doFirst(() -> printThreadName("first1"))
                .subscribe(v -> printThreadName("sub " + v));

        for (int i = 0; i < 2; i++) {
            new Thread(runnable).start();
        }

        Util.sleepSeconds(5);
    }

    private static void printThreadName(String msg) {
        System.out.println(Thread.currentThread().getName() + "\t\t : " + msg );
    }
}
