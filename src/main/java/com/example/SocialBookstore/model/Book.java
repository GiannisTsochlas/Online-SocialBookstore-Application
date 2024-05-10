package com.example.SocialBookstore.model;

import jakarta.persistence.*;

@Entity
@Table(name="bookoffers")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="offer_id")
    private int offer_id;
    @Column(name="book_title")
    private String book_title;
    @Column(name="authors")
    private String authors;
    @Column(name="category")
    private String category;
    @Column(name="summary")
    private String summary;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User users;

    public User getUser() {
        return users;
    }

    public void setUser(User users) {
        this.users = users;
    }

    public Book() {}

    public int getOffer_id() {
        return offer_id;
    }

    public void setOffer_id(int offer_id) {
        this.offer_id = offer_id;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
