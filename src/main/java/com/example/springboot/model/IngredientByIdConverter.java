package com.example.springboot.model;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.springboot.repository.IngredientRepository;


@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

        private IngredientRepository ingredientRepository;

        //@Autowired
        public IngredientByIdConverter(IngredientRepository ingredientRepository) {
                this.ingredientRepository = ingredientRepository;
        }


        @Override
        public Ingredient convert(String id) {
                return ingredientRepository.findById(id).orElse(null);
        }

}
