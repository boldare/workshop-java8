package pl.xsolve.workshops.java8.stream.part3.parallel;

import pl.xsolve.workshops.java8.stream.Book;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookServiceSolutions {

    BookDaoImpl bookDao = new BookDaoImpl();

    public List<Book> findByIdsSequentially(Collection<Integer> ids){
        return findNonNullBooks(ids.stream());
    }

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
