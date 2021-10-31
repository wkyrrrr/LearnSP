package com.study.tacos.data;

import com.study.tacos.Ingredient;

/**
 * @author abner
 */
public interface IngredientRepository {
    Iterable<Ingredient> findAll();
    Ingredient findOne(String id);
    Ingredient save(Ingredient ingredient);
}
