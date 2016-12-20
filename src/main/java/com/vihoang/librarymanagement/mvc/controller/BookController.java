package com.vihoang.librarymanagement.mvc.controller;

import com.vihoang.librarymanagement.mvc.models.Author;
import com.vihoang.librarymanagement.mvc.models.Book;
import com.vihoang.librarymanagement.mvc.services.AuthorService;
import com.vihoang.librarymanagement.mvc.services.BookService;
import com.vihoang.librarymanagement.mvc.services.CategoryService;
import com.vihoang.librarymanagement.mvc.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by MyPC on 12/12/2016.
 */
@Controller
public class BookController {

    private BookService bookService;

    private CategoryService categoryService;

    private AuthorService authorService;

    private NotificationService notificationService;

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Autowired
    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Autowired
    public void setNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String list(Model model) {

        model.addAttribute("authors",authorService.listAllAuthors());
        model.addAttribute("categories",categoryService.listAllCategory());
        model.addAttribute("books", bookService.listAllBooks());
        model.addAttribute("book", new Book());
        System.out.println("Returning books:");

        return "books";
    }

    @RequestMapping(value = "book/save", method = RequestMethod.POST)
    public String createBook(@ModelAttribute("book") Book book, final RedirectAttributes redirectAttributes) {
        if (bookService.saveBook(book) != null) {
            redirectAttributes.addFlashAttribute("saveMessage","Book Created Success");
        }
        else{
            redirectAttributes.addFlashAttribute("saveMessage","Book Created Failed");
        }
        return "redirect:/books";
    }

    @RequestMapping("book/create")
    public String newBook(Model model) {
        model.addAttribute("book", new Book());
        return "redirect:/books";
    }
}
