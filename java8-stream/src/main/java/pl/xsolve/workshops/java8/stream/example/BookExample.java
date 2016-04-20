package pl.xsolve.workshops.java8.stream.example;

import pl.xsolve.workshops.java8.stream.Book;

import java.util.*;
import java.util.stream.Stream;

public class BookExample {

    int nameFilterCounter = 0;
    int pageFilterCounter = 0;
    int sortCounter = 0;

    protected List<Book> books;

    public void init(){

        books = new ArrayList<>();
        String tolkien = "J.R.R. Tolkien";
        String rowling = "J.K. Rowling";
        String norris = "David Norris";
        String theGod = "God Almighty";

        books.addAll(Arrays.asList(
                new Book("The Lord of the Rings", tolkien, 1216),
                new Book("Silmarillion", tolkien,  365),
                new Book("Harry Potter and the Philosopher's Stone", rowling, 223),
                new Book("Harry Potter and the Half-Blood Prince", rowling, 554),
                new Book("Harry Potter and the Deathly Hallows", rowling, 607),
                new Book("Teach yourself Croatian", norris, 352),
                new Book("The Bible", theGod, 1200),
                new Book("The Hobbit", tolkien, 320)
        ));
    }

    protected void resetCounters(){
        nameFilterCounter = 0;
        pageFilterCounter = 0;
        sortCounter = 0;
    }

    protected void java7Approach() {
        // TODO: find out the authors of the top-3 thickest books, other than the Bible

        // 1. filter out the Bible
        List<Book> booksFiltered = new ArrayList<>();
        for (Book book : books){
            if (! "The Bible".equals(book.getTitle())) {
                booksFiltered.add(book);
            }
        }

        // 2. sort by number of pages, descending
        booksFiltered.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o2.getPages().compareTo(o1.getPages());
            }
        });

        System.out.println("\nJava 7 approach:");
        // 3. list the authors
        for (int i=0; i<3; i++) {
            System.out.println(booksFiltered.get(i).getAuthor());
        }
    }

    protected void streamApproach(){
        System.out.println("\nStreams approach:");

        books.stream()
                .filter(b -> ! "The Bible".equals(b.getTitle()))
                .sorted((b1, b2) -> b2.getPages().compareTo(b1.getPages()))
                .limit(3)
                .map(Book::getAuthor)
                .distinct()
                .forEach(System.out::println);
    }

    public void lazy(){

        System.out.println("\nfindFirst():");
        books.stream()
                .filter(it -> {
                    System.out.println("name: " + nameFilterCounter++);
                    return "J.K. Rowling".equals(it.getAuthor());
                })
                .filter(it -> {
                    System.out.println("\tpages: " + pageFilterCounter++);
                    return it.getPages() > 500;
                })
                .findFirst();

        resetCounters();
        System.out.println("\nallMatch():");
        books.stream()
                .filter(it -> {
                    System.out.println(nameFilterCounter++);
                    return "J.K. Rowling".equals(it.getAuthor());
                })
                .allMatch(it -> it.getPages() < 500);


        resetCounters();
        System.out.println("\nfirst sorted():");
        books.stream()
                .sorted((b1, b2) -> {
                    System.out.println("sort: " + sortCounter++);
                    return b1.getPages().compareTo(b2.getPages());
                })
                .filter(it -> {
                    System.out.println("filter: " + nameFilterCounter++);
                    return "J.K. Rowling".equals(it.getAuthor());
                })
                .allMatch(it -> it.getPages() < 500);

        resetCounters();
        System.out.println("\nfirst filtered():");
        books.stream()
                .filter(it -> {
                    System.out.println("filter: " + nameFilterCounter++);
                    return "J.K. Rowling".equals(it.getAuthor());
                })
                .sorted((b1, b2) -> {
                    System.out.println("sort: " + sortCounter++);
                    return b1.getPages().compareTo(b2.getPages());
                })
                .allMatch(it -> it.getPages() < 500);

    }

    public static void main(String... args){
        BookExample bookExample = new BookExample();
        bookExample.init();
        bookExample.java7Approach();
        bookExample.streamApproach();

        bookExample.lazy();
    }





}
