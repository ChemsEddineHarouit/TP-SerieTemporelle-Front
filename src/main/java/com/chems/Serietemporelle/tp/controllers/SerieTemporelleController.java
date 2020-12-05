package com.chems.Serietemporelle.tp.controllers;

import com.chems.Serietemporelle.tp.TpApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
public class SerieTemporelleController {
    public static void main(String[] args) {
        SpringApplication.run(TpApplication.class, args);
    }


    @GetMapping("/seriestemporelles")
    public String getList(Model model){
        model.addAttribute("msg", "hello");
        return "list_serietemporelle";
    }

}
