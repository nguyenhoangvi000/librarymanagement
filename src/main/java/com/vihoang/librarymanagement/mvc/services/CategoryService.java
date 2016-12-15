package com.vihoang.librarymanagement.mvc.services;

import com.vihoang.librarymanagement.mvc.models.Category;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MyPC on 15/12/2016.
 */
@Service
public interface CategoryService {

    Iterable<Category> listAllCategory();

    Category getCategorybyId(Long Id);

    Category saveCategory(Category book);

    void deleteCategory(Long Id);

    public List<Category> findLatest5Category(Pageable pageable);

}
