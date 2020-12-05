package com.chems.Serietemporelle.tp.models;

import java.io.Serializable;
import java.util.Objects;

public class Partage implements Serializable {

    private Long id;

    private User user;

    private SerieTemporelle serieTemporelle;

    private String type;

    public Partage(User user, SerieTemporelle serieTemporelle, String type) {
        this.user = user;
        this.serieTemporelle = serieTemporelle;
        this.type = type;
    }

    public Partage() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SerieTemporelle getSerieTemporelle() {
        return serieTemporelle;
    }

    public void setSerieTemporelle(SerieTemporelle serieTemporelle) {
        this.serieTemporelle = serieTemporelle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        Partage partage = (Partage) o;
        return partage.getId().equals(this.id) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
