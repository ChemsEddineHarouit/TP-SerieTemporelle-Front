package com.chems.Serietemporelle.tp.controllers;

import ch.qos.logback.core.net.server.Client;
import com.chems.Serietemporelle.tp.TpApplication;
import com.chems.Serietemporelle.tp.models.Event;
import com.chems.Serietemporelle.tp.models.In.SerieTemporelleIn;
import com.chems.Serietemporelle.tp.models.ModelLists.EventList;
import com.chems.Serietemporelle.tp.models.ModelLists.SerieTemplorelleList;
import com.chems.Serietemporelle.tp.models.SerieTemporelle;
import com.chems.Serietemporelle.tp.routes.EventsRoutes;
import com.chems.Serietemporelle.tp.routes.SeriesTemporellesRoutes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
public class SerieTemporelleController {

    RestTemplate restTemplate = new RestTemplate();
    SeriesTemporellesRoutes seriesTemporellesRoutes= SeriesTemporellesRoutes.getInstance();
    EventsRoutes eventsRoutes= EventsRoutes.getInstance();

    @GetMapping("/seriestemporelles")
    public String getList(Model model){
        String url = seriesTemporellesRoutes.getListUrl();
        ResponseEntity<SerieTemplorelleList> listeEntity = restTemplate.getForEntity(url, SerieTemplorelleList.class);
        SerieTemplorelleList liste = listeEntity.getBody();
        model.addAttribute("seriestemporelles", liste.getSeriestemporelles());
        return "serietemporelle/liste";
    }

    @GetMapping("/seriestemporelles/detail/{id}")
    public String getDetail(@PathVariable String id, Model model){
        String url = seriesTemporellesRoutes.getFindByIdUrl(id);
        ResponseEntity<SerieTemporelle> serieTemporelleResponseEntity = restTemplate.getForEntity(url, SerieTemporelle.class);
        SerieTemporelle serieTemporelle = serieTemporelleResponseEntity.getBody();
        model.addAttribute("serieTemporelle", serieTemporelle);

        url = eventsRoutes.getListOfSerieTemporelleUrl(id);
        ResponseEntity<EventList> eventResponseEntity = restTemplate.getForEntity(url, EventList.class);
        EventList events = eventResponseEntity.getBody();
        model.addAttribute("events", events.getEvents());

        return "serietemporelle/detail";
    }

    @GetMapping("/seriestemporelles/create/form/{owner}")
    public String getCreate(@PathVariable String owner, Model model, SerieTemporelleIn serieTemporelleIn){
        model.addAttribute("createUrl", "/seriestemporelles/create/"+owner);
        model.addAttribute("owner", owner);
        return "serietemporelle/create";
    }

    @PostMapping(value="/seriestemporelles/create/{owner}", consumes = "application/x-www-form-urlencoded")
    public String postCreate(@PathVariable String owner,  SerieTemporelleIn serieTemporelleIn){

        String url = seriesTemporellesRoutes.getCreateUrl(owner);
        ResponseEntity<SerieTemporelle> serieTemporelleResponseEntity = restTemplate.postForEntity(url, serieTemporelleIn, SerieTemporelle.class);
        SerieTemporelle newSerieTemporelle = serieTemporelleResponseEntity.getBody();
        return "redirect:/seriestemporelles/detail/"+newSerieTemporelle.getId();
    }

    @GetMapping("/seriestemporelles/modifier/form/{id}")
    public String getModifier(@PathVariable String id, Model model){
        String url = seriesTemporellesRoutes.getFindByIdUrl(id);
        ResponseEntity<SerieTemporelle> serieTemporelleResponseEntity = restTemplate.getForEntity(url, SerieTemporelle.class);
        SerieTemporelle serieTemporelle = serieTemporelleResponseEntity.getBody();
        SerieTemporelleIn serieTemporelleIn = new SerieTemporelleIn(serieTemporelle.getId(), serieTemporelle.getTitre(), serieTemporelle.getDescription());
        model.addAttribute("serieTemporelleIn", serieTemporelleIn);
        model.addAttribute("updateUrl", "/seriestemporelles/modifier/"+id);
        return "serietemporelle/modifier";
    }

    @PostMapping(value="/seriestemporelles/modifier/{id}", consumes = "application/x-www-form-urlencoded")
    public String postModifier(@PathVariable String id,  SerieTemporelleIn serieTemporelleIn){

        String url = seriesTemporellesRoutes.getUpdateUrl(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<SerieTemporelleIn> entity = new HttpEntity<>(serieTemporelleIn, headers);
        ResponseEntity<SerieTemporelle> serieTemporelleResponseEntity = restTemplate.exchange(url, HttpMethod.PUT, entity, SerieTemporelle.class);
        SerieTemporelle newSerieTemporelle = serieTemporelleResponseEntity.getBody();
        return "redirect:/seriestemporelles/detail/"+newSerieTemporelle.getId();
    }

    @GetMapping(value="/seriestemporelles/supprimer/{id}")
    public String getDelete(@PathVariable String id){
        String url = seriesTemporellesRoutes.getDeleteUrl(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<SerieTemporelleIn> entity = new HttpEntity<>(headers);
        ResponseEntity<SerieTemporelle> serieTemporelleResponseEntity = restTemplate.exchange(url, HttpMethod.DELETE, entity, SerieTemporelle.class);
        SerieTemporelle newSerieTemporelle = serieTemporelleResponseEntity.getBody();
        return "redirect:/seriestemporelles";
    }



}
