package com.example.springboot;

@Data
public class Ingridient {
    private final String id;
    private final String name;
    private final Type type;
    
    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
