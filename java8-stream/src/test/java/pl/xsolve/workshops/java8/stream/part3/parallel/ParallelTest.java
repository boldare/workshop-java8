package pl.xsolve.workshops.java8.stream.part3.parallel;

import org.junit.Assert;
import org.junit.Test;
import pl.xsolve.workshops.java8.stream.Book;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class ParallelTest {

    protected static final int BOOK_COUNT = 8;
    protected List<Integer> bookIds = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    protected BookService bookService = new BookService();

    @Test
    public void findSequentially(){
        List<Book> bookList = bookService.findByIdsSequentially(bookIds);
        Assert.assertEquals("was: " + bookList, BOOK_COUNT, bookList.size());
    }

    @Test
    public void findParalelly(){
        List<Book> bookList = bookService.findByIdsParalelly(bookIds);
        Assert.assertEquals("was: " + bookList, BOOK_COUNT, bookList.size());
    }

    @Test
    public void parallelShouldBeFasterThanSequential(){
        long sequentialDuration = measureTime(() -> bookService.findByIdsSequentially(bookIds));
        long parallelDuration = measureTime(() -> bookService.findByIdsParalelly(bookIds));

        Assert.assertTrue("parallel: " + parallelDuration + ", sequential: " + sequentialDuration, sequentialDuration > parallelDuration);
    }

    public long measureTime(Supplier operation){
        Instant start = Instant.now();
        operation.get();
        return Duration.between(start, Instant.now()).toMillis();
    }
}
