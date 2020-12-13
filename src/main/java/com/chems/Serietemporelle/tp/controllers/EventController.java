package com.chems.Serietemporelle.tp.controllers;

import com.chems.Serietemporelle.tp.models.Event;
import com.chems.Serietemporelle.tp.models.In.EventIn;
import com.chems.Serietemporelle.tp.models.In.SerieTemporelleIn;
import com.chems.Serietemporelle.tp.models.ModelLists.EventList;
import com.chems.Serietemporelle.tp.models.ModelLists.SerieTemplorelleList;
import com.chems.Serietemporelle.tp.models.SerieTemporelle;
import com.chems.Serietemporelle.tp.routes.EventsRoutes;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class EventController {

    RestTemplate restTemplate = new RestTemplate();
    EventsRoutes eventsRoutes = EventsRoutes.getInstance();

    @GetMapping("/events/detail/{id}")
    public String getDetail(@PathVariable String id, Model model){
        String url = eventsRoutes.getFindByIdUrl(id);
        ResponseEntity<Event> eventResponseEntity = restTemplate.getForEntity(url, Event.class);
        Event event = eventResponseEntity.getBody();
        model.addAttribute("event", event);
        return "event/detail";
    }

    @GetMapping("/seriestemporelles/{serieTemporelleId}/events/create/form")
    public String getCreate(@PathVariable String serieTemporelleId, Model model, EventIn eventIn){
        model.addAttribute("createUrl", "/seriestemporelles/"+ serieTemporelleId +"/events/create/");
        return "event/create";
    }

    @PostMapping(value="/seriestemporelles/{serieTemporelleId}/events/create", consumes = "application/x-www-form-urlencoded")
    public String postCreate(@PathVariable String serieTemporelleId,  EventIn eventIn){
        String url = eventsRoutes.getCreateUrl(serieTemporelleId);
        restTemplate.postForEntity(url, eventIn, SerieTemporelle.class);
        return "redirect:/seriestemporelles/detail/"+serieTemporelleId;
    }

    @GetMapping("/events/modifier/form/{id}")
    public String getModifier(@PathVariable String id, Model model){
        String url = eventsRoutes.getFindByIdUrl(id);
        ResponseEntity<Event> eventResponseEntity = restTemplate.getForEntity(url, Event.class);
        Event event = eventResponseEntity.getBody();
        EventIn eventIn = new EventIn(event.getId(), event.getDate(), event.getValeur(), event.getCommentaire());
        model.addAttribute("eventIn", eventIn);
        model.addAttribute("updateUrl", "/events/modifier/"+id);
        return "event/modifier";
    }

    @PostMapping(value="/events/modifier/{id}", consumes = "application/x-www-form-urlencoded")
    public String postModifier(@PathVariable String id,  EventIn eventIn){

        String url = eventsRoutes.getUpdateUrl(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<EventIn> entity = new HttpEntity<>(eventIn, headers);
        ResponseEntity<Event> eventResponseEntity = restTemplate.exchange(url, HttpMethod.PUT, entity, Event.class);
        Event newEvent = eventResponseEntity.getBody();
        return "redirect:/events/detail/"+newEvent.getId();
    }

    @GetMapping(value="/events/supprimer/{id}")
    public String getDelete(@PathVariable String id){
        String url = eventsRoutes.getFindByIdUrl(id);
        ResponseEntity<Event> eventResponseEntity = restTemplate.getForEntity(url, Event.class);
        Event event = eventResponseEntity.getBody();
        long serieTemporelleId = event.getSerieTemporelle().getId();

        url = eventsRoutes.getDeleteUrl(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<EventIn> entity = new HttpEntity<>(headers);
        restTemplate.exchange(url, HttpMethod.DELETE, entity, Event.class);

        return "redirect:/seriestemporelles/detail/"+serieTemporelleId;
    }



}
