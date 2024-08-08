package com.example.demo.model;

import com.example.demo.views.Views;
import com.fasterxml.jackson.annotation.JsonView;

public class PersonaDTO {
    @JsonView(Views.Public.class)
    public String name;
    @JsonView(Views.Private.class)
    public int age;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
}
