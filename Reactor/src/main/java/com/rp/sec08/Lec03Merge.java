package com.rp.sec08;

import com.rp.sec08.helper.AmericanAirlines;
import com.rp.sec08.helper.Emirates;
import com.rp.sec08.helper.Qatar;
import courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec03Merge {

    public static void main(String[] args) {
        Flux<String> mergedFlux = Flux.merge(
                Qatar.getFlights(),
                Emirates.getFlights(),
                AmericanAirlines.getFlights()
        );

        mergedFlux.subscribe(Util.subscriber());

        Util.sleepSeconds(10);
    }
}
