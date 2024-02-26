package com.rp.sec03;

import courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec06FluxGenerateAssignment {

    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
                    String name = Util.faker().country().name();
                    synchronousSink.next(name);

                    if(name.toLowerCase().equals("canada"))
                        synchronousSink.complete();
                })
                .subscribeWith(Util.subscriber());
    }

}
