package com.sign.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "genre")
    private String genre;

    @Column(name = "isbn")
    private long isbn;


    @Column(name = "name")
    private String name;

    @Column(name = "number_of_pages")
    private int numberOfPages;

    @ManyToOne(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.REFRESH})
    @JoinColumn(name = "writer_id")
    private Writer writer;

    @OneToMany(mappedBy = "books", cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.REFRESH})
    private List<BookUser> bookAssoc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Writer getWriter() {
        return writer;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    public Book() {}

    public Book(int isbn, String name, int numberOfPages, String genre, Writer writer) {
        this.isbn = isbn;
        this.name = name;
        this.numberOfPages = numberOfPages;
        this.genre = genre;
        this.writer = writer;
    }
}
