package com.rp.sec05;

import courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec03HotPublish {

    // share = publish().refCount(1)
    // share makes a cold publisher to hot
    public static void main(String[] args) {
        Flux<String> movieStream = Flux.fromStream(() -> getMovie())
                .delayElements(Duration.ofSeconds(2))
                .publish()
                .refCount(2);

        movieStream.subscribeWith(Util.subscriber("sam"));

        Util.sleepSeconds(5);

        movieStream.subscribeWith(Util.subscriber("mike"));

        Util.sleepSeconds(15);
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
