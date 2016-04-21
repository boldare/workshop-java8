package pl.xsolve.workshops.java8.stream.part0.example;


import pl.xsolve.workshops.java8.stream.Book;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Stream;

public class CodeSnippets {

    public void snippets(){
        List aList = new ArrayList();
        aList.stream();

        Collection aCollection = new LinkedHashSet<>();
        aCollection.stream(); // Stream

        Integer[] anArray = {1, 2, 3, 4, 5};
        Stream.of(anArray); // Stream<Integer>

        Stream aStream = Stream.of("Hickory", "Dickory", "Dock"); // Stream<String>

        String name = "David";
        name.chars(); // IntStream

        aList.stream().filter(o -> o != null); // Stream from another stream!

        List<Book> bookCollection = new ArrayList<>();
        bookCollection.parallelStream().forEach(book -> {
                    // do some badass long operation on the book
                }
        );

        Stream<Book> bookStream = bookCollection.stream();
        bookStream.parallel().forEach(book -> {
                    // do some badass long operation on the book
                }
        );

    }

}
