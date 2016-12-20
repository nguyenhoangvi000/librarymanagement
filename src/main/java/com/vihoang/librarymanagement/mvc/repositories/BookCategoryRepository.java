package com.vihoang.librarymanagement.mvc.repositories;

import com.vihoang.librarymanagement.mvc.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by MyPC on 14/12/2016.
 */
@Repository
public interface BookCategoryRepository extends JpaRepository<Category,Long> {

}
