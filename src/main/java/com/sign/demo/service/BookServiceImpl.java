package com.sign.demo.service;

import com.sign.demo.dao.BookRepository;
import com.sign.demo.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void saveBook(Book book) {
        this.bookRepository.save(book);

    }

    @Override
    public Book getBookById(int id) {
        Optional <Book> optional = bookRepository.findById(id);
        Book book = null;

        if (optional.isPresent()) {
            book = optional.get();
        } else {
            throw new RuntimeException("Not found for id: " + id);
        }
        return book;
    }

    @Override
    public void deleteBookById(int id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public List<Book> findByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }


}
