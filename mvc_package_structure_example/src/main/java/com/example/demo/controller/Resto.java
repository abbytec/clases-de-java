package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.PersonaDTO;
import com.example.demo.views.Views;
import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class Resto {
    @PostMapping("all")
    public PersonaDTO postMethodName(@RequestBody PersonaDTO param) {
        return param;
    }

    @PostMapping("show-private")
    @JsonView(Views.Private.class)
    public PersonaDTO postMethodName2(@RequestBody PersonaDTO param) {
        return param;
    }

    @PostMapping("show-public")
    @JsonView(Views.Public.class)
    public PersonaDTO postMethodName3(@RequestBody PersonaDTO param) {
        return param;
    }

    @PostMapping("show-all")
    @JsonView(Views.All.class)
    public PersonaDTO postMethodName4(@RequestBody PersonaDTO param) {
        return param;
    }

}
