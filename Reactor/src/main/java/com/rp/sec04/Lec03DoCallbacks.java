package com.rp.sec04;

import courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec03DoCallbacks {

    public static void main(String[] args) {
        System.out.println(Long.MAX_VALUE);
        Flux.create(fluxSink -> {
            for (int i = 0; i < 5; i++) {
                fluxSink.next(i);
            }
            //fluxSink.complete();
            fluxSink.error(new RuntimeException("oops"));
            System.out.println("--completed");
        })
        .doFirst(() -> System.out.println("doFirst"))
        .doOnComplete(() -> System.out.println("doOnComplete"))
        .doOnNext(o -> System.out.println("doOnNext: " + o))
        .doOnSubscribe(subscription -> System.out.println("doOnSubscribe: " + subscription))
        .doOnRequest(l -> System.out.println("doOnRequest: " + l))
        .doOnDiscard(Object.class, o -> System.out.println("doOnDiscard: " + o))
        .doOnError(throwable -> System.out.println("doOnError: " + throwable.getMessage()))
        .doOnTerminate(() -> System.out.println("doOnTerminate"))
        .doFinally(signalType -> System.out.println("doFinally: " + signalType))
        .doOnCancel(() -> System.out.println("doOnCancel"))
        .take(2)
        .subscribeWith(Util.subscriber())
        ;
    }
}
