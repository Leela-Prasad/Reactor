package com.rp.sec01;

import courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {
    public static void main(String[] args) {
        Mono<Integer> mono = Mono.just("ball")
                                    .map(s -> s.length())
                                    .map(l -> l/1);

        // 1
        // mono.subscribe();

        // 2
        mono.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }
}
