package com.vihoang.librarymanagement.mvc.controller;

import com.vihoang.librarymanagement.mvc.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by MyPC on 12/12/2016.
 */
@Controller
public class BookController {


    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("books",bookService.listAllBooks());
        System.out.println("Returning books:");
        return "books";
    }
}
