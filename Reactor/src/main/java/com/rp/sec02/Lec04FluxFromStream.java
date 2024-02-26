package com.rp.sec02;

import courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;

public class Lec04FluxFromStream {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4);
        Stream<Integer> stream = list.stream();

        /*Flux.fromStream(list.stream())
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        Flux.fromStream(list.stream())
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());*/

        Flux.fromStream(() -> list.stream())
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        Flux.fromStream(() -> list.stream())
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());
    }
}
