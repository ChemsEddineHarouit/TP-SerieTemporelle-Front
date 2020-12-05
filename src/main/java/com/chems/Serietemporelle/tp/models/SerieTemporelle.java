package com.chems.Serietemporelle.tp.models;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class SerieTemporelle implements Serializable {

    private Long id;

    private String titre;

    private String description;

    private User owner;


    public SerieTemporelle(Long id, String titre, String description, User owner) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.owner = owner;
    }

    public SerieTemporelle() {
    }

    public SerieTemporelle(String titre, String description) {
        this.titre=titre;
        this.description=description;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        SerieTemporelle serieTemporelle = (SerieTemporelle) o;
        return serieTemporelle.id == this.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
