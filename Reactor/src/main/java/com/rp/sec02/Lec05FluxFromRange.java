package com.rp.sec02;

import courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxFromRange {

    public static void main(String[] args) {
        /*Flux.range(3, 11)
                .subscribe(Util.onNext());*/

        Flux.range(1, 11)
                .log()
                .map(i -> Util.faker().name().fullName())
                .log()
                .subscribe(Util.onNext());
    }
}
