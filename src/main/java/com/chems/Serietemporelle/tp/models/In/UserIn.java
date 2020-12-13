package com.chems.Serietemporelle.tp.models.In;


import java.io.Serializable;
import java.util.Objects;

public class UserIn implements Serializable {

    private Long id;

    private java.lang.String username;

    private java.lang.String password;


    public UserIn(Long id, java.lang.String username, java.lang.String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public UserIn(java.lang.String username, java.lang.String password) {
        this.username = username;
        this.password = password;
    }

    public UserIn() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.lang.String getUsername() {
        return username;
    }

    public void setUsername(java.lang.String username) {
        this.username = username;
    }


    public java.lang.String getPassword() {
        return password;
    }

    public void setPassword(java.lang.String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        UserIn user = (UserIn) o;
        return user.id == this.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
