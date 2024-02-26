package com.rp.sec03.assignment;

import courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class FileReaderService {

    public static void main(String[] args) {
        Path PATH = Paths.get("src/main/resources/sample.txt");
        new FileReaderService().read(PATH)
                .map(line -> {
                    Integer integer = Util.faker().random().nextInt(1, 9);
                    if(integer > 5)
                        throw new RuntimeException("Intentional");
                    return line;
                })
                .subscribeWith(Util.subscriber());
    }

    private Callable<BufferedReader> openReader(Path path) {
        return () -> Files.newBufferedReader(path);
    }

    private BiFunction<BufferedReader, SynchronousSink<String>, BufferedReader> read() {
        return (br, sink) -> {
            try {
                String line = br.readLine();
                System.out.println("Reading Line: " + line);
                if(Objects.isNull(line))
                    sink.complete();
                else
                    sink.next(line);
            } catch (IOException e) {
                sink.error(e);
            }
            return br;
        };
    }

    private Consumer<BufferedReader> closeReader() {
        return br -> {
            try {
                br.close();
                System.out.println("File Closed");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public Flux<String> read(Path path) {
       return Flux.generate(
                openReader(path),
                read(),
                closeReader()
        );
    }

}
