package com.example.springboot;

import java.util.List;

import lombok.Data;

@Data
public class Taco {
    private String name;
    private List<Ingridient> ingridients;
}
