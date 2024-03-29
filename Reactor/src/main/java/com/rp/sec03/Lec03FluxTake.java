package com.rp.sec03;

import courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec03FluxTake {

    public static void main(String[] args) {
        Flux.range(1, 10)
                .log()
                .take(3)
                .log()
                .subscribeWith(Util.subscriber());
    }
}
