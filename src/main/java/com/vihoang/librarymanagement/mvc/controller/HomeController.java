package com.vihoang.librarymanagement.mvc.controller;

import com.vihoang.librarymanagement.mvc.repositories.BookCategoryRepository;
import com.vihoang.librarymanagement.mvc.services.BookService;
import com.vihoang.librarymanagement.mvc.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by MyPC on 10/12/2016.
 */
@Controller
public class HomeController {

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

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("categories", categoryService.listAllCategory());
        model.addAttribute("books", bookService.findLatest4Book(new PageRequest(0, 4)));
        model.addAttribute("booksrandom", bookService.findLatest4BookRandom(new PageRequest(0, 4)));
        model.addAttribute("books3", bookService.findLatest3Book(new PageRequest(0, 3)));

        System.out.println("Returning books:");
        return "index";
    }
}
