package com.example.springboot.repository;

import java.util.Optional;

import com.example.springboot.model.Ingredient;

public interface IngredientRepository {
    Iterable<Ingredient> findAll();
    Optional<Ingredient> findById(String id);
    Ingredient save(Ingredient ingredient);
}
