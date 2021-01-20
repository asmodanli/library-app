package com.sign.demo.service;

import com.sign.demo.dao.BookRepository;
import com.sign.demo.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository repository) {
        bookRepository = repository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAllByOrdOrderByName();
    }

    @Override
    public Book findById(int theId) {
        Optional<Book> result = bookRepository.findById(theId);
        Book book = null;

        if(result.isPresent()) {
            book = result.get();
        }
        else {
            throw new RuntimeException("didn't find it" + theId);
        }
        return book;
    }

    @Override
    public Book findByIsbn(int theIsbn) {
        Book result = bookRepository.findByIsbn(theIsbn);
        if(result != null) {
            return result;
        }
        else {
            throw new RuntimeException("didn't find isbn" + theIsbn);
        }
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);

    }

    @Override
    public void deleteById(int theId) {
        bookRepository.deleteById(theId);

    }

    @Override
    public void deleteByIsbn(int theIsbn) {
        bookRepository.deleteBookByIsbn(theIsbn);

    }
}
