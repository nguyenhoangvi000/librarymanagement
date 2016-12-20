package com.vihoang.librarymanagement.mvc.services;

import com.vihoang.librarymanagement.mvc.models.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MyPC on 12/12/2016.
 */
@Service
public interface BookService {

    Iterable<Book> listAllBooks();

    Book getBookbyId(Long Id);

    Book saveBook(Book book);

    void deleteBook(Long Id);

    public List<Book> findLatest4Book(Pageable pageable);

    public List<Book> findLatest3Book(Pageable pageable);

    public List<Book> findLatest4BookRandom(Pageable pageable);

    public List<Book> findBookByCategory(Long categoryID);

}
