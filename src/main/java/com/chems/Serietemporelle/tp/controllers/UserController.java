package com.chems.Serietemporelle.tp.controllers;

import com.chems.Serietemporelle.tp.models.In.UserIn;
import com.chems.Serietemporelle.tp.models.User;
import com.chems.Serietemporelle.tp.routes.UsersRoutes;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
public class UserController {

    RestTemplate restTemplate = new RestTemplate();
    UsersRoutes usersRoutes = UsersRoutes.getInstance();

    @GetMapping("/users/detail/{id}")
    public String getDetail(@PathVariable String id, Model model){
        String url = usersRoutes.getFindByIdUrl(id);
        ResponseEntity<User> userResponseEntity = restTemplate.getForEntity(url, User.class);
        User user = userResponseEntity.getBody();
        model.addAttribute("user", user);
        return "user/detail";
    }

    @GetMapping("/users/create/form")
    public String getCreate(Model model, UserIn userIn){
        model.addAttribute("createUrl", "/users/create/");
        return "user/create";
    }

    @PostMapping(value="/users/create", consumes = "application/x-www-form-urlencoded")
    public String postCreate(UserIn userIn){

        String url = usersRoutes.getCreateUrl();
        ResponseEntity<User> userResponseEntity = restTemplate.postForEntity(url, userIn, User.class);
        return "redirect:/";
    }

}
