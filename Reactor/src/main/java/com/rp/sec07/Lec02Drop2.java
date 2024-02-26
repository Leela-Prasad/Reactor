package com.rp.sec07;

import courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;

public class Lec02Drop2 {

    public static void main(String[] args) {

        System.setProperty("reactor.bufferSize.small", "16");

        List list = new ArrayList<>();

        Flux.create(fluxSink -> {
                    for (int i = 1; i < 201; i++) {
                        fluxSink.next(i);
                        System.out.println("Pushed: " + i);
                        Util.sleepMilliSeconds(1);
                    }
                })
                .onBackpressureDrop(list::add)
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i -> Util.sleepMilliSeconds(10))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(10);
        System.out.println(list);
    }
}
