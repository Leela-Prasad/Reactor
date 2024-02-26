package com.rp.sec01;

import courseutil.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class Lec07MonoFromFuture {

    public static void main(String[] args) {
        Mono.fromFuture(getName())
                .subscribe(Util.onNext());

        System.out.println("Before Sleep");
        Util.sleepSeconds(3);
        System.out.println("After Sleep");
    }

    private static CompletableFuture<String> getName() {
        return CompletableFuture.supplyAsync(() -> {
            Util.sleepSeconds(2);
            return Util.faker().name().fullName();
        });
    }
}
