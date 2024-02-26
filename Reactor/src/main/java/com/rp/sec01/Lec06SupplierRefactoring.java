package com.rp.sec01;

import courseutil.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class Lec06SupplierRefactoring {

    public static void main(String[] args) {
        getName();
        // Below commented block still executes in blocking mode
        /*getName()
                .subscribe(Util.onNext());*/

        getName()
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(Util.onNext());

        /*String name = getName()
                .subscribeOn(Schedulers.boundedElastic())
                .block();
        System.out.println(name);*/
        getName();

        Util.sleepSeconds(5);
    }

    private static Mono<String> getName() {
        System.out.println("entered getName method");
        return Mono.fromSupplier(() -> {
            System.out.println("Generating Name");
            Util.sleepSeconds(3);
            return Util.faker().name().firstName();
        }).map(String::toUpperCase);
    }
}
