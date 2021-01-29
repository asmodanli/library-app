package com.sign.demo.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "writer")
public class Writer {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;


    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "writer", cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Book> books;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Writer() {}

    public Writer(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }
}
