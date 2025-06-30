package site.nomoreparties.stellarburgers.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import site.nomoreparties.stellarburgers.page.Ingredient;
import site.nomoreparties.stellarburgers.page.IngredientType;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class IngredientParamTest {

    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientParamTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тип: {0}, Название: \"{1}\", Цена: {2}")
    public static Collection<Object[]> getData() {
        return Arrays.asList(new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100f},
                {IngredientType.SAUCE, "sour cream", 150.5f},
                {IngredientType.FILLING, "cutlet", 200f},
                {IngredientType.FILLING, "sausage", 300.75f}
        });
    }

    @Test
    public void testIngredientFields() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(name, ingredient.getName());
        assertEquals(type, ingredient.getType());
        assertEquals(price, ingredient.getPrice(), 0.01);
    }
}