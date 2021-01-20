package com.sign.demo.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BookUserId implements Serializable {

    @Column(name = "book_id")
    private int bookId;

    @Column(name = "user_id")
    private int userId;

    public BookUserId() {}

    public BookUserId(int bookId, int userId) {
        this.bookId = bookId;
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;
        BookUserId bookUserId = (BookUserId) o;
        return Objects.equals(bookId, bookUserId.bookId) &&
                Objects.equals(userId, bookUserId.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId,userId);
    }
}

