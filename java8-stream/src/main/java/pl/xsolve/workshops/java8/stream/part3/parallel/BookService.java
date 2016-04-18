package pl.xsolve.workshops.java8.stream.part3.parallel;

import pl.xsolve.workshops.java8.stream.Book;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class BookService {

    BookDaoImpl bookDao = new BookDaoImpl();

    public List<Book> findByIdsSequentially(Collection<Integer> ids){
        return findNonNullBooks(ids.stream());
    }

    /**
     * Finds books with given IDs in BookDao
     * @param ids Collection of book IDs
     * @return List of non-null Books with given IDs
     */
    //TODO: Implement using a parallel stream.
    public List<Book> findByIdsParalelly(Collection<Integer> ids){
        return new ArrayList<>();
    }

    /**
     * Finds books with given IDs in BookDao
     * @param idStream Stream of book IDs
     * @return List of non-null Books with given IDs
     */
    //TODO: implement finding only books with existing IDs, using bookDao.findById object
    protected List<Book> findNonNullBooks(Stream<Integer> idStream){
        return new ArrayList<>();
    }

}
