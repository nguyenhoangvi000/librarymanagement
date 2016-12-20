package com.vihoang.librarymanagement.mvc.services;


import com.vihoang.librarymanagement.mvc.models.Book;
import com.vihoang.librarymanagement.mvc.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MyPC on 12/12/2016.
 */
@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> listAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookbyId(Long Id) {
        return bookRepository.findOne(Id);
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long Id) {
        bookRepository.delete(Id);
    }

    @Override
    public List<Book> findLatest4Book(Pageable pageable) {
        return this.bookRepository.findLatest4Book(new PageRequest(0, 4));
    }

    @Override
    public List<Book> findLatest3Book(Pageable pageable) {
        return this.bookRepository.findLatest3Book(new PageRequest(0, 3));
    }

    @Override
    public List<Book> findLatest4BookRandom(Pageable pageable) {
        return this.bookRepository.findLatest4BookRandom(new PageRequest(0, 4));
    }

    @Override
    public List<Book> findBookByCategory(Long categoryID) {
        return this.bookRepository.findBooksByCategory(categoryID);
    }
}
