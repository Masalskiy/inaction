package com.example.springboot;

import java.util.Arrays;
import java.util.List;

public class DesignTacoController {
    public void addIngredientsToModel(){
        List<Ingridient> ingridients = Arrays.asList(
            new Ingridient("null", "null", Ingridient.Type.CHEESE));
    }
}
