package site.nomoreparties.stellarburgers.tests;

import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.page.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BurgerTest {

    private Burger burger;
    private Bun bun;
    private Ingredient sauce;
    private Ingredient filling;

    @Before
    public void setUp() {
        burger = new Burger();
        bun = new Bun("Sesame Bun", 100f);

        //  Мок соуса
        sauce = mock(Ingredient.class);
        when(sauce.getName()).thenReturn("Ketchup");
        when(sauce.getType()).thenReturn(IngredientType.SAUCE);
        when(sauce.getPrice()).thenReturn(50f);

        // Мок начинки
        filling = mock(Ingredient.class);
        when(filling.getName()).thenReturn("Beef");
        when(filling.getType()).thenReturn(IngredientType.FILLING);
        when(filling.getPrice()).thenReturn(200f);
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(sauce);
        assertEquals(1, burger.ingredients.size());
        assertEquals(sauce, burger.ingredients.get(0));
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(sauce);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void testMoveIngredient() {
        Ingredient another = mock(Ingredient.class);
        when(another.getName()).thenReturn("Mustard");
        when(another.getType()).thenReturn(IngredientType.SAUCE);
        when(another.getPrice()).thenReturn(60f);

        burger.addIngredient(sauce);
        burger.addIngredient(another);
        burger.moveIngredient(0, 1);

        assertEquals(another, burger.ingredients.get(0));
        assertEquals(sauce, burger.ingredients.get(1));
    }

    @Test
    public void testGetPrice() {
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        float expectedPrice = 100f * 2 + 50f + 200f;
        assertEquals(expectedPrice, burger.getPrice(), 0.001f);
    }

    @Test
    public void testGetReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        String receipt = burger.getReceipt();

        // Проверяем структуру чека
        assertTrue(receipt.contains("(==== Sesame Bun ====)"));
        assertTrue(receipt.contains("= sauce Ketchup ="));
        assertTrue(receipt.contains("= filling Beef ="));
        assertTrue(receipt.contains("Price:"));
    }
}