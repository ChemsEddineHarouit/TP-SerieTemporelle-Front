package com.chems.Serietemporelle.tp.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class Event implements Serializable {

    private Long id;

    private Date date;

    private Float valeur;

    private String commentaire;

    private SerieTemporelle serieTemporelle;

    public Event() {
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float getValeur() {
        return valeur;
    }

    public void setValeur(Float valeur) {
        this.valeur = valeur;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public SerieTemporelle getSerieTemporelle() {
        return serieTemporelle;
    }

    public void setSerieTemporelle(SerieTemporelle serieTemporelle) {
        this.serieTemporelle = serieTemporelle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        Event user = (Event) o;
        return user.id == this.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
