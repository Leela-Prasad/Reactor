package com.rp.sec09;

import courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec02Buffer {

    public static void main(String[] args) {
        eventStream()
                .buffer(Duration.ofSeconds(2))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }

    private static Flux<String> eventStream() {
        return Flux.interval(Duration.ofMillis(300))
                .map(i -> "event " + i);
    }
}
