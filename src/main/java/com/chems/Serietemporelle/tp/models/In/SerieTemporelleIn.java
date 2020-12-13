package com.chems.Serietemporelle.tp.models.In;

import java.io.Serializable;
import java.util.Objects;

public class SerieTemporelleIn implements Serializable {

    private Long id;

    private java.lang.String titre;

    private java.lang.String description;



    public SerieTemporelleIn(Long id, java.lang.String titre, java.lang.String description) {
        this.id = id;
        this.titre = titre;
        this.description = description;
    }

    public SerieTemporelleIn() {
    }

    public SerieTemporelleIn(java.lang.String titre, java.lang.String description) {
        this.titre=titre;
        this.description=description;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.lang.String getTitre() {
        return titre;
    }

    public void setTitre(java.lang.String titre) {
        this.titre = titre;
    }


    public java.lang.String getDescription() {
        return description;
    }

    public void setDescription(java.lang.String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        SerieTemporelleIn serieTemporelle = (SerieTemporelleIn) o;
        return serieTemporelle.id == this.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
