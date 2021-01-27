package com.sign.demo.dao;

import com.sign.demo.entity.Book;
import com.sign.demo.entity.Writer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WriterRepository extends JpaRepository<Writer, Integer> {
}
