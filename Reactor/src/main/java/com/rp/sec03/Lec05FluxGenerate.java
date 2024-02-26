package com.rp.sec03;

import courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxGenerate {
    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
            String name = Util.faker().country().name();
            synchronousSink.next(name);
        })
                .subscribeWith(Util.subscriber());
    }
}
