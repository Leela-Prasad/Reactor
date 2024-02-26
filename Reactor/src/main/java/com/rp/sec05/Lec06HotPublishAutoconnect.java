package com.rp.sec05;

import courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec06HotPublishAutoconnect {

    // share = publish().refCount(1)
    // share makes a cold publisher to hot
    public static void main(String[] args) {
        Flux<String> movieStream = Flux.fromStream(() -> getMovie())
                .delayElements(Duration.ofSeconds(1))
                .publish()
                .autoConnect(0);

        Util.sleepSeconds(3);

        movieStream.subscribeWith(Util.subscriber("sam"));

        Util.sleepSeconds(10);

        System.out.println("Mike about to join");
        
        movieStream.subscribeWith(Util.subscriber("mike"));

        Util.sleepSeconds(25);
    }

    //movie theatre
    private static Stream<String> getMovie() {
        System.out.println("Got the movie streaming request");
        return Stream.of(
                "Scene1",
                "Scene2",
                "Scene3",
                "Scene4",
                "Scene5",
                "Scene6",
                "Scene7"
        );
    }
}
