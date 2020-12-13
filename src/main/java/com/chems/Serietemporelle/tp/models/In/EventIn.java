package com.chems.Serietemporelle.tp.models.In;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class EventIn implements Serializable {

    private Long id;

    private Date date;

    private Float valeur;

    private String commentaire;


    public EventIn() {
    }

    public EventIn(Long id, Date date, Float valeur, String commentaire) {
        this.id = id;
        this.date = date;
        this.valeur = valeur;
        this.commentaire = commentaire;
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        EventIn user = (EventIn) o;
        return user.id == this.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
