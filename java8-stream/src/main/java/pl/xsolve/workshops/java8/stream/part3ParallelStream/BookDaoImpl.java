package pl.xsolve.workshops.java8.stream.part3ParallelStream;

import pl.xsolve.workshops.java8.stream.Book;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BookDaoImpl {
    protected static final Map<Integer, Book> data = new HashMap<>();
    static{
        String tolkien = "J.R.R. Tolkien";
        String rowling = "J.K. Rowling";
        String norris = "David Norris";
        String theGod = "God Almighty";

        data.put(1, new Book("The Lord of the Rings", tolkien, 1216));
        data.put(2, new Book("Silmarillion", tolkien,  365));
        data.put(3, new Book("Harry Potter and the Philosopher's Stone", rowling, 223));
        data.put(4, new Book("Harry Potter and the Half-Blood Prince", rowling, 554));
        data.put(5, new Book("Harry Potter and the Deathly Hallows", rowling, 607));
        data.put(6, new Book("Teach yourself Croatian", norris, 352));
        data.put(7, new Book("The Bible", theGod, 1200));
        data.put(8, new Book("The Hobbit", tolkien, 320));
    }

    public Optional<Book> findById(Integer id){
        try {
            Thread.sleep(200);
        }
        catch (InterruptedException e){
            // just accept the interruption
        }
        finally {
            return Optional.ofNullable(data.get(id));
        }
    }
}
