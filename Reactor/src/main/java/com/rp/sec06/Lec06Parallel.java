package com.rp.sec06;

import courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Lec06Parallel {

    public static void main(String[] args) {

        ArrayList list = new ArrayList();
        //CopyOnWriteArrayList list = new CopyOnWriteArrayList();

        Flux.range(1, 1000)
                .parallel()
                .runOn(Schedulers.parallel())
                //.doOnNext(i -> printThreadName("next " + i))
                //.subscribe(v -> printThreadName("sub " + v));
                // Here since it is parallel we should consider thread safety
                .subscribe(v -> list.add(v));


        Util.sleepSeconds(5);
        System.out.println(list.size());
    }

    private static void printThreadName(String msg) {
        System.out.println(Thread.currentThread().getName() + "\t\t : " + msg );
    }
}
