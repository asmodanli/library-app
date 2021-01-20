package com.sign.demo.dao;

import com.sign.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    public List<Book> findAllByOrdOrderByName();
    public void deleteBookByIsbn(int isbn);
    public Book findByIsbn(int isbn);
}
