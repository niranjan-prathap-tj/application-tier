package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Wish {

    @Id
    private String wish;

    Wish() {}

    Wish(String wish) {
        this.wish = wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }

    public String getWish() {
        return this.wish;
    }

}
