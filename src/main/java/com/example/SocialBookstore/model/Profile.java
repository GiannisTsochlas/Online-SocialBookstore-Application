package com.example.SocialBookstore.model;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;

@Entity
@Table(name="Profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id")
    private int p_id;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;

    @Column(name = "full_name")
    private String full_name;

    @Column(name = "address")
    private String address;

    @Column(name = "age")
    private String age;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "book_categories")
    private String book_categories;
    @Column(name = "favorite_authors")
    private String favorite_authors;

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getBook_categories() {
        return book_categories;
    }

    public void setBook_categories(String book_categories) {
        this.book_categories = book_categories;
    }

    public String getFavorite_authors() {
        return favorite_authors;
    }

    public void setFavorite_authors(String favorite_authors) {
        this.favorite_authors = favorite_authors;
    }


}


