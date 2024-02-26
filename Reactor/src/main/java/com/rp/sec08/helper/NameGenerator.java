package com.rp.sec08.helper;

import courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {

    List<String> list = new ArrayList<>();

    public Flux<String> generateNames() {
        return Flux.generate(synchronousSink -> {
            System.out.println("Received Fresh");
            Util.sleepSeconds(1);
            String name = Util.faker().name().firstName();
            list.add(name);
            synchronousSink.next(name);
        })
        .cast(String.class)
        .startWith(generateNamesFromCache());
    }

    private Flux<String> generateNamesFromCache() {
        return Flux.fromIterable(list);
    }
}
