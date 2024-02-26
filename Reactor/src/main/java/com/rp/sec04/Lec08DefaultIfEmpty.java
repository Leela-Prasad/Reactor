package com.rp.sec04;

import courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec08DefaultIfEmpty {

    public static void main(String[] args) {

        getOrderNumbers()
                .filter(i -> i > 10)
                .defaultIfEmpty(-100)
                .subscribeWith(Util.subscriber());
    }

    private static Flux<Integer> getOrderNumbers() {
        return Flux.range(1, 10);
    }
}
