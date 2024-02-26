package com.rp.sec02;

import courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec10FluxToMono {

    public static void main(String[] args) {
        Flux.range(1, 10)
                .next()
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());
    }
}
