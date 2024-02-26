package com.rp.sec08;

import courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec02Concat {

    public static void main(String[] args) {
        Flux<String> flux1 = Flux.just("a", "b");
        Flux<String> flux2 = Flux.just("c", "d", "e");
        Flux<String> errorFlux = Flux.error(new RuntimeException("oops"));

//        Flux<String> flux = flux1.concatWith(flux2);
//        Flux<String> flux = Flux.concat(flux1, flux2);
//        Flux<String> flux = Flux.concat(flux1, errorFlux, flux2);
        Flux<String> flux = Flux.concatDelayError(flux1, errorFlux, flux2);

        flux.subscribe(Util.subscriber());

    }
}
