package com.chems.Serietemporelle.tp.models;

import java.io.Serializable;
import java.util.Objects;

public class Tag implements Serializable {

    private Long id;

    private String name;

    private Event event;

    public Tag(Long id, String name, Event event) {
        this.id = id;
        this.name = name;
        this.event = event;
    }

    public Tag(String name, Event event) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
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
