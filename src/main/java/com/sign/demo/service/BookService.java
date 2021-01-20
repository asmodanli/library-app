package com.sign.demo.service;

import com.sign.demo.entity.Book;

import java.util.List;

public interface BookService {

    public List<Book> findAll();
    public Book findById(int theId);
    public Book findByIsbn(int theIsbn);
    public void save(Book book);
    public void deleteById(int theId);
    public void deleteByIsbn(int theIsbn);
}
