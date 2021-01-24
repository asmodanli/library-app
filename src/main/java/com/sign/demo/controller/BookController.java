package com.sign.demo.controller;

import com.sign.demo.entity.Book;
import com.sign.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/list")
    public String listBooks(Model theModel) {
        theModel.addAttribute("listBooks", bookService.getAllBooks());
        return "books/list-books";
    }

    @GetMapping("/showNewBookForm")
    public String showNewBookForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "new_book";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("save") Book theBook) {
        bookService.saveBook(theBook);
        return  "redirect:/books/list";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);

        return "update_book";
    }

    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable(value = "id") int id) {

        this.bookService.deleteBookById(id);

        return "redirect:/";
    }


}












