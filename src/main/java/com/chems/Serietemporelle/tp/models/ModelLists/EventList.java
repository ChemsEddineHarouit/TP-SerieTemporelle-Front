package com.chems.Serietemporelle.tp.models.ModelLists;


import com.chems.Serietemporelle.tp.models.Event;

import java.util.List;

public class EventList {


    private List<Event> events;
    private int count;

    public EventList(List<Event> events) {
        this.events = events;
        this.count = events.size();
    }

    public EventList() {
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
