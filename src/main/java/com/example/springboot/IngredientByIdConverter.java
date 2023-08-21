package com.example.springboot;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.example.springboot.Ingridient.Type;

@Component
public class IngredientByIdConverter implements Converter<String, Ingridient> {

    private Map<String, Ingridient> ingredientMap = new HashMap<>();

    public IngredientByIdConverter() {
        ingredientMap.put("FLTO",
                new Ingridient("FLTO", "Flour Tortilla", Type.WRAP));
        ingredientMap.put("COTO",
                new Ingridient("COTO", "Corn Tortilla", Type.WRAP));
        ingredientMap.put("GRBF",
                new Ingridient("GRBF", "Ground Beef", Type.PROTEIN));
        ingredientMap.put("CARN",
                new Ingridient("CARN", "Carnitas", Type.PROTEIN));
        ingredientMap.put("TMTO",
                new Ingridient("TMTO", "Diced Tomatoes", Type.VEGGIES));
        ingredientMap.put("LETC",
                new Ingridient("LETC", "Lettuce", Type.VEGGIES));
        ingredientMap.put("CHED",
                new Ingridient("CHED", "Cheddar", Type.CHEESE));
        ingredientMap.put("JACK",
                new Ingridient("JACK", "Monterrey Jack", Type.CHEESE));
        ingredientMap.put("SLSA",
                new Ingridient("SLSA", "Salsa", Type.SAUCE));
        ingredientMap.put("SRCR",
                new Ingridient("SRCR", "Sour Cream", Type.SAUCE));
                /*пока нет БД */
    }

    @Override
    public Ingridient convert(String id) {
        return ingredientMap.get(id);
    }

}
