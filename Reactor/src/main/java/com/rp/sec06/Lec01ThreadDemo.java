package com.rp.sec06;

import courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec01ThreadDemo {

    public static void main(String[] args) {

        Flux<Object> flux = Flux.create(fluxSink -> {
            printThreadName("create");
            fluxSink.next(1);
        }).doOnNext(i -> printThreadName("next " + i));

//        flux.subscribe(v -> printThreadName("sub " + v));
        Runnable runnable = () -> flux.subscribe(v -> printThreadName("sub " + v));

        for (int i = 0; i < 2; i++) {
            new Thread(runnable).start();
        }

        Util.sleepSeconds(5);
    }

    private static void printThreadName(String msg) {
        System.out.println(Thread.currentThread().getName() + "\t\t : " + msg );
    }
}
