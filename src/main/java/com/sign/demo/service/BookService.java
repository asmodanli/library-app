package com.sign.demo.service;

import com.sign.demo.entity.Book;

import java.util.List;

public interface BookService {

    public List<Book> getAllBooks();
    public void saveBook(Book book);
    Book getBookById(int id);
    void deleteBookById(int id);

}
