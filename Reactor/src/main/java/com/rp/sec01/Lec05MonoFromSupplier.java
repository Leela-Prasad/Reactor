package com.rp.sec01;

import courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec05MonoFromSupplier {

    public static void main(String[] args) {

        // use just only when we have data already
        // or if we want to execute the logic eagerly
        // Mono<String> mono = Mono.just(getName());

        Mono<String> mono = Mono.fromSupplier(() -> getName());
        mono.subscribe(
                Util.onNext()
        );

        Mono<String> mono1 = Mono.fromCallable(() -> getName());
        mono1.subscribe(
                Util.onNext()
        );

    }

    public static String getName() {
        System.out.println("Generating Name ...");
        return Util.faker().name().fullName();
    }
}
