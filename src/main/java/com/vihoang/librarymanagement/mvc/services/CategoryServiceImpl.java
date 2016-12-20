package com.vihoang.librarymanagement.mvc.services;

import com.vihoang.librarymanagement.mvc.models.Category;
import com.vihoang.librarymanagement.mvc.repositories.BookCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MyPC on 15/12/2016.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    private BookCategoryRepository bookCategoryRepository;

    @Autowired
    public void setBookCategoryRepository(BookCategoryRepository bookCategoryRepository) {
        this.bookCategoryRepository = bookCategoryRepository;
    }

    @Override
    public Iterable<Category> listAllCategory() {
        return bookCategoryRepository.findAll();
    }

    @Override
    public Category getCategorybyId(Long Id) {
        return bookCategoryRepository.findOne(Id);
    }

    @Override
    public Category saveCategory(Category category) {
        System.out.println(category.getCategoryName());
        return bookCategoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long Id) {
        bookCategoryRepository.delete(Id);
    }


    @Override
    public List<Category> findLatest5Category(Pageable pageable) {
        return null;
    }


}
