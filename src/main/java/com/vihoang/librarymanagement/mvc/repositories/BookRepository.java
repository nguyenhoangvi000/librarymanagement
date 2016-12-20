package com.vihoang.librarymanagement.mvc.repositories;

import com.vihoang.librarymanagement.mvc.models.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MyPC on 12/12/2016.
 */
@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    @Query("SELECT p FROM Book p ORDER BY p.date DESC")
    List<Book> findLatest4Book(Pageable pageable);

    @Query("SELECT p FROM Book p ORDER BY RAND()")
    List<Book> findLatest3Book(Pageable pageable);

    @Query("SELECT p FROM Book p ORDER BY RAND()")
    List<Book> findLatest4BookRandom(Pageable pageable);

    @Query("SELECT p FROM Book p WHERE p.category.catID= :catID")
    List<Book> findBooksByCategory(@Param("catID") Long catID);

}
