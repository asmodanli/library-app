package com.sign.demo.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "book_user")
public class BookUser {


    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book books;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User users;

    @Temporal(TemporalType.DATE)
    @Column(name = "borrow_date")
    private Date borrowDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "delivery_date")
    private Date deliveryDate;

    @Column(name = "is_given_back")
    private char isGivenBack;

    public Book getBooks() {
        return books;
    }

    public void setBooks(Book books) {
        this.books = books;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public char getIsGivenBack() {
        return isGivenBack;
    }

    public void setIsGivenBack(char isGivenBack) {
        this.isGivenBack = isGivenBack;
    }

    public BookUser() {}

    public BookUser(Book books, User users, Date borrowDate, Date deliveryDate, char isGivenBack) {
        this.books = books;
        this.users = users;
        this.borrowDate = borrowDate;
        this.deliveryDate = deliveryDate;
        this.isGivenBack = isGivenBack;
    }
}
