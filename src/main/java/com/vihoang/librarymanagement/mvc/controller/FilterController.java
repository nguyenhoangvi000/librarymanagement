package com.vihoang.librarymanagement.mvc.controller;

import com.vihoang.librarymanagement.mvc.services.BookService;
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

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }
    @RequestMapping(value = "/filter/category={id}",method = RequestMethod.POST)
    public String filter(@PathVariable String catID, Model model)
    {
        model.addAttribute("books",bookService.findBookByCategory(catID));
        return "filter";
    }
}
