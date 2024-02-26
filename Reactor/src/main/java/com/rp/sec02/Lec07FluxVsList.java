package com.rp.sec02;

import com.rp.sec02.util.NameGenerator;
import courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.List;

public class Lec07FluxVsList {
    public static void main(String[] args) {
        /*List<String> names = NameGenerator.getNames(5);
        System.out.println(names);*/

        Flux<String> names = NameGenerator.getNames(5);
        names.subscribe(Util.onNext());
    }
}
