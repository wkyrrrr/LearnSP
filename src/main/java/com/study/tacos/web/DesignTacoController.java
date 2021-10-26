package com.study.tacos.web;

import com.study.tacos.Ingredient;
import com.study.tacos.Taco;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import com.study.tacos.Ingredient.Type;

import javax.validation.Valid;

/**
 * @author abner
 */

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {
    @GetMapping
    public String showDesignForm(Model model){
        List<Ingredient> ingredients = Arrays.asList(
          new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP),
          new Ingredient("COTO", "Flour Tortilla00", Ingredient.Type.WRAP),
          new Ingredient("FLTO1", "Flour Tortilla1", Ingredient.Type.PROTEIN),
          new Ingredient("FLTO2", "Flour Tortilla2", Ingredient.Type.PROTEIN),
          new Ingredient("FLTO3", "Flour Tortilla3", Ingredient.Type.VEGGIES),
          new Ingredient("FLTO4", "Flour Tortilla4", Ingredient.Type.VEGGIES),
          new Ingredient("FLTO5", "Flour Tortilla5", Ingredient.Type.CHEESE),
          new Ingredient("FLTO6", "Flour Tortilla6", Ingredient.Type.CHEESE),
          new Ingredient("FLTO7", "Flour Tortilla7", Ingredient.Type.SAUCE),
          new Ingredient("FLTO8", "Flour Tortilla8", Ingredient.Type.SAUCE)
        );

        Type[] types = Ingredient.Type.values();
        for(Type type : types){
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
        model.addAttribute("design", new Taco());

        return "design";
    }

    private Object filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients.stream().filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

    @PostMapping
    public String processDesign(@Valid @ModelAttribute("design") Taco design, Errors errors){
        if(errors.hasErrors()){
            return "design";
        }

        log.info("Processing design: " + design);

        return "redirect:/orders/current";
    }
}
