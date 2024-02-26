package com.rp.sec06;

import courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

public class Lec07FluxInterval {

    public static void main(String[] args) {

        // Here interval uses Schedulers.parallel()
        // so it will be executed in a different thread pool
        // and we cannot override with subscribeon as publisher will take precedence
        Flux.interval(Duration.ofSeconds(1))
                .subscribe(i -> printThreadName("Received " + i));

        Util.sleepSeconds(2);
    }

    private static void printThreadName(String msg) {
        System.out.println(Thread.currentThread().getName() + "\t\t : " + msg);
    }
}
