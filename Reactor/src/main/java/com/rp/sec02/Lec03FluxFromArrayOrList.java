package com.rp.sec02;

import courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.List;

public class Lec03FluxFromArrayOrList {

    public static void main(String[] args) {
        /*List<String> list = List.of("a", "b", "c");
        Flux.fromIterable(list)
                .subscribe(Util.onNext());*/

        Integer[] arr = {1, 2, 3};
        Flux.fromArray(arr)
                .subscribe(Util.onNext());

    }
}
