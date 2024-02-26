package com.rp.sec02.util;

import courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {

    /*public static List<String> getNames(int count) {
        List names = new ArrayList(count);
        for (int i = 0; i < count; i++) {
            names.add(getName());
        }
        return names;
    }*/

    public static Flux<String> getNames(int count) {
       return Flux.range(1, count)
               .map(i -> getName());
    }

    public static String getName() {
        Util.sleepSeconds(1);
        return Util.faker().name().fullName();
    }
}
