package com.chems.Serietemporelle.tp.models.In;

import java.io.Serializable;
import java.util.Objects;

public class Partage implements Serializable {

    private Long id;

    private UserIn user;

    private SerieTemporelleIn serieTemporelle;

    private java.lang.String type;

    public Partage(UserIn user, SerieTemporelleIn serieTemporelle, java.lang.String type) {
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

    public UserIn getUser() {
        return user;
    }

    public void setUser(UserIn user) {
        this.user = user;
    }

    public SerieTemporelleIn getSerieTemporelle() {
        return serieTemporelle;
    }

    public void setSerieTemporelle(SerieTemporelleIn serieTemporelle) {
        this.serieTemporelle = serieTemporelle;
    }

    public java.lang.String getType() {
        return type;
    }

    public void setType(java.lang.String type) {
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
