package com.chems.Serietemporelle.tp.models.In;

import java.io.Serializable;
import java.util.Objects;

public class Tag implements Serializable {

    private Long id;

    private UserIn name;

    private EventIn event;

    public Tag(Long id, UserIn name, EventIn event) {
        this.id = id;
        this.name = name;
        this.event = event;
    }

    public Tag(UserIn name, EventIn event) {
        this.name = name;
        this.event = event;
    }

    public Tag() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserIn getName() {
        return name;
    }

    public void setName(UserIn name) {
        this.name = name;
    }

    public EventIn getEvent() {
        return event;
    }

    public void setEvent(EventIn event) {
        this.event = event;
    }

    @Override
    public boolean equals(Object o) {
        Tag tag = (Tag) o;
        return tag.getId().equals(this.id) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
