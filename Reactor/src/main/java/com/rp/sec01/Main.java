package com.rp.sec01;

import courseutil.Util;
import reactor.core.publisher.Mono;

public class Main {
    public static void main(String[] args) {
        /*Mono.fromSupplier(() -> {
            Util.sleepSeconds(5);
            return Util.faker().name().fullName();
        }).subscribe(Util.onNext());*/

        /*Mono.fromCallable(() -> {
            Util.sleepSeconds(5);
            return Util.faker().name().fullName();
        }).subscribe(Util.onNext());*/

        Mono.fromRunnable(() -> {
            Util.sleepSeconds(5);
            System.out.println(Util.faker().name().fullName());
        }).subscribe(Util.onNext());

        System.out.println("Before Sleep");
        Util.sleepSeconds(3);
        System.out.println("After Sleep");
    }


}