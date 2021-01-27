package com.sign.demo.service;

import com.sign.demo.dao.WriterRepository;
import com.sign.demo.entity.Writer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WriterServiceImpl implements WriterService{

    @Autowired
    private WriterRepository writerRepository;

    @Override
    public List<Writer> getAllWriters() {
        return writerRepository.findAll();
    }
}
