package com.sign.demo.service;

import com.sign.demo.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();
    void saveBook(Book book);
    Book getBookById(int id);
    void deleteBookById(int id);
    List<Book> findByIsbn(String isbn);

}
