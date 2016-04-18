package pl.xsolve.workshops.java8.stream.part0.example;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMethodExamples {

    public static void main(String ... args){

        // forEach():
        System.out.println("\nforEach()");
        Stream.of("Facebook", "Google", "xSolve")
                .forEach(System.out::println);

        // forEach() - doesnt modify the underlying list:
        System.out.println("\nforEach() - doesnt modify the underlying list");
        List<String> list = Arrays.asList("Facebook", "Google", "xSolve");
        System.out.println(list);
        list.stream().forEach(String::toUpperCase);
        System.out.println(list);


        // map():
        System.out.println("\nmap():");
        Stream.of("Facebook", "Google", "xSolve")
                .map(str -> str.startsWith("x"))
                .forEach(System.out::println);

        // mapToInt():
        System.out.println("\nmapToInt():");
        int sum = Stream.of("1", "2", "3")
                .mapToInt(Integer::parseInt)
                .sum();
        System.out.println(sum);

        // filter():
        System.out.println("\nfilter():");
        Stream.of("Facebook", "Google", "xSolve")
                .filter(str -> Character.isLowerCase(str.charAt(0)))
                .forEach(System.out::println);

        // findFirst():
        System.out.println("\nfindFirst():");
        String firstFound  = Stream.of("Facebook", "Google", "xSolve")
                .filter(str -> str.contains("oo"))
                .findFirst()
                .get();
        System.out.println(firstFound);

        // findAny():
        System.out.println("\nfindAny():");
        String anyFound  = Stream.of("Facebook", "Google", "xSolve")
                .parallel()
                .findAny()
                .get();
        System.out.println(anyFound);

        // collect():
        System.out.println("\ncollect():");
        List<String> uppers = Stream.of("cyan", "magenta", "yellow", "black")
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(uppers);

        // toArray():
        Object[] objArray = Stream.of("cyan", "magenta", "yellow", "black")
                .map(String::toUpperCase)
                .toArray();
        String[] strArray = Stream.of("cyan", "magenta", "yellow", "black")
                .map(String::toUpperCase)
                .toArray(String[]::new);

        // reduce() with "starter":
        System.out.println("\nreduce() with starter:");
        String concatStarter = Stream.of("A", "n", "n", "a")
                .reduce("Lady ", String::concat);
        System.out.println(concatStarter);

        // reduce() without "starter":
        System.out.println("\nreduce() without starter:");
        String concat = Stream.of("A", "n", "n", "a")
                .reduce(String::concat)
                .get();
        System.out.println(concat);

        // allMatch():
        System.out.println("\nallMatch(): ");
        boolean allMatch = Stream.of("Veronica", "Anna", "Patricia", "Alan", "Thomas")
            .allMatch(str -> str.endsWith("a"));
        System.out.println(allMatch);

        // noneMatch():
        System.out.println("\nnoneMatch(): ");
        boolean noneMatch = Stream.of("Veronica", "Anna", "Patricia", "Alan", "Thomas")
                .noneMatch(str -> str.endsWith("a"));
        System.out.println(noneMatch);

        // anyMatch():
        System.out.println("\nanyMatch(): ");
        boolean anyMatch = Stream.of("Veronica", "Anna", "Patricia", "Alan", "Thomas")
                .anyMatch(str -> str.endsWith("a"));
        System.out.println(anyMatch);

        // breaking the law - modifying local variable in forEach():
        System.out.println("\nsum in forEach: ");
        int[] total = {0};
        Stream.of("Mercury", "Venus", "Mars")
                .forEach(str -> {
                    total[0] += str.length();
                });
        System.out.println(total[0]);

        // peek():
        System.out.println("\npeek(): ");
        Stream.of("Mercury", "Venus", "Earth")
                .filter(str -> str.length() < 7)
                .peek(System.out::println)
                .filter(str -> str.startsWith("E"))
                .forEach(System.out::println);

    }
}
