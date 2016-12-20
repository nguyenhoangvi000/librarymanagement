package com.vihoang.librarymanagement.mvc.controller;

import com.vihoang.librarymanagement.mvc.services.BookService;
import com.vihoang.librarymanagement.mvc.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by MyPC on 16/12/2016.
 */
@Controller
public class FilterController {

    private BookService bookService;

    private CategoryService categoryService;

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/filter/category/{id}",method = RequestMethod.GET)
    public String bookfilter(@PathVariable("id") Long id, Model model)
    {
        model.addAttribute("categories", categoryService.listAllCategory());
        model.addAttribute("books",bookService.findBookByCategory(id));
        return "filter";
    }
}
