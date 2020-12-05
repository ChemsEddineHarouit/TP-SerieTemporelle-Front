package com.chems.Serietemporelle.tp.models;


import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

public class User implements Serializable {

    private Long id;

    private String username;

    private String password;


    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        User user = (User) o;
        return user.id == this.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
