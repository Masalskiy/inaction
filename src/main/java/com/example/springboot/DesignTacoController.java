package com.example.springboot;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.springboot.Ingredient.Type;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public DesignTacoController(IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }

    private Iterable<Ingredient> filterByType(Iterable<Ingredient> ingredients, Type type) {
        List<Ingredient> ingredientsList = new ArrayList<Ingredient>();
        ingredients.forEach(ingredientsList::add);

        return  ingredientsList.stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model){

        Iterable<Ingredient> ingredients = ingredientRepository.findAll();


        Type[] types = Ingredient.Type.values();
        for(Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), 
            filterByType(ingredients, type));
        }
    }

    @ModelAttribute(name="tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }

    @ModelAttribute(name="taco") 
    public Taco taco(){
        return new Taco();
    }
    /*Объект Taco помещается в модель, чтобы представление, отображаемое в ответ на
запрос GET с путем /design, имело объект для отображения. */

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    @PostMapping
    public String processTaco(@Valid Taco taco, Errors errors,
                                @ModelAttribute TacoOrder tacoOrder){
        if(errors.hasErrors()) {
            return "design";
        }
        tacoOrder.addTacko(taco);
        log.info("Processing taco: {}", taco);
        return "redirect:/orders/current";
    }
}
