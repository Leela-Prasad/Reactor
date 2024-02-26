package com.rp.sec01;

import courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec08MonoFromRunnable {

    public static void main(String[] args) {
        Mono.fromRunnable(timeConsumingProcess())
            .subscribe(Util.onNext(),
                    Util.onError(),
                    () -> {
                        System.out.println("Process is done, sending emails...");
                    });
    }

    private static Runnable timeConsumingProcess() {
        return () -> {
            Util.sleepSeconds(3);
            System.out.println("Operation Completed");
        };
    }
}
