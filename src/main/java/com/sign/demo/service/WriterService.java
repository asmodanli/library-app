package com.sign.demo.service;

import com.sign.demo.entity.Writer;

import java.util.List;

public interface WriterService {
    List<Writer> getAllWriters();
    void saveWriter(Writer writer);
}
