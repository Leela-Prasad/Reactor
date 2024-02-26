package com.rp.sec01.assignment;

import courseutil.Util;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;

public class FileService {

    private static final Path PATH = Paths.get("src/main/resources");
    
    public static void main(String[] args) {
//        read("File1.txt").subscribe(Util.onNext(), Util.onError(), Util.onComplete());
//        create("sample.txt", "This is sample text").subscribe(Util.onNext(), Util.onError(), Util.onComplete());
//        delete("sample.txt").subscribe(Util.onNext(), Util.onError(), Util.onComplete());
    }
    
    public static Mono<String> read(String fileName) {
        return Mono.fromSupplier(() -> readFile(fileName));
    }

    public static Mono<Void> create(String fileName, String content) {
        return Mono.fromRunnable(() -> createFile(fileName, content));
    }

    public static Mono<Void> delete(String fileName) {
        return Mono.fromRunnable(() -> deleteFile(fileName));
    }
    private static String readFile(String fileName) {
        try {
            return Files.readString(PATH.resolve(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void createFile(String fileName, String content) {
        try {
            Path filePath = Files.createFile(PATH.resolve(fileName));
            Files.writeString(filePath, content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void deleteFile(String fileName) {
        try {
            Files.delete(PATH.resolve(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
