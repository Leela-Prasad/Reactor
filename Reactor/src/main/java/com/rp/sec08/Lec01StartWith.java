package com.rp.sec08;

import com.rp.sec08.helper.NameGenerator;
import courseutil.Util;

public class Lec01StartWith {

    public static void main(String[] args) {
        NameGenerator generator = new NameGenerator();

        generator.generateNames()
                .take(2)
                .subscribe(Util.subscriber("sam"));

        generator.generateNames()
                .take(2)
                .subscribe(Util.subscriber("mike"));

        generator.generateNames()
                .take(3)
                .subscribe(Util.subscriber("mike"));

        generator.generateNames()
                .filter(name -> name.startsWith("A"))
                .take(1)
                .subscribe(Util.subscriber("mike"));
    }
}
