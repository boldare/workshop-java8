package pl.xsolve.workshops.java8.stream.part3ParallelStream;

import pl.xsolve.workshops.java8.stream.Book;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookService {

    BookDaoImpl bookDao = new BookDaoImpl();

    public List<Book> findByIdsSequentially(Collection<Integer> ids){
        return findNonNullBooks(ids.stream());
    }

    //TODO: leave same as findByIdsSequentially
    /**
     * Implement using a parallel stream.
     */
    public List<Book> findByIdsParalelly(Collection<Integer> ids){
        return findNonNullBooks(ids.parallelStream());
    }

    protected List<Book> findNonNullBooks(Stream<Integer> idStream){
        return idStream
                .map(bookDao::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }


}
