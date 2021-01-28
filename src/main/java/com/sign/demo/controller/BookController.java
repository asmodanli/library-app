package com.sign.demo.controller;

import com.sign.demo.entity.Book;
import com.sign.demo.entity.Writer;
import com.sign.demo.service.BookService;
import com.sign.demo.service.WriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private WriterService writerService;

    @GetMapping("/listBooks")
    public String viewBookPage(Model theModel, String isbn) {

        if(isbn != null) {
            theModel.addAttribute("listBooks", bookService.findByIsbn(isbn));
        }
        else if(isbn == ""){
            theModel.addAttribute("listBooks", bookService.getAllBooks());
        }
        else{
            theModel.addAttribute("listBooks", bookService.getAllBooks());
        }

        return "books/book";
    }


    @GetMapping("/showNewBookForm")
    public String showNewBookForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        model.addAttribute("listWriters", writerService.getAllWriters());
        return "books/add-book";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book theBook) {

        bookService.saveBook(theBook);
        return  "redirect:/admin/listBooks";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);

        return "books/update-book";
    }

    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable(value = "id") int id) {

        this.bookService.deleteBookById(id);

        return "redirect:/admin/listBooks";
    }



}












