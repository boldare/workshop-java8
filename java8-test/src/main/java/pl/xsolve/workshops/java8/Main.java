package pl.xsolve.workshops.java8;

import java.util.Arrays;

public class Main {
    public static void main(String... args) {
        Arrays.asList("hello,", "world").stream().forEach(System.out::println);
    }
}
