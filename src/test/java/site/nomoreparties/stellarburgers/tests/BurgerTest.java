package site.nomoreparties.stellarburgers.tests;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import site.nomoreparties.stellarburgers.page.Bun;
import site.nomoreparties.stellarburgers.page.Burger;
import site.nomoreparties.stellarburgers.page.Ingredient;
import site.nomoreparties.stellarburgers.page.IngredientType;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BurgerTest {

    private Burger burger;
    private Bun bunMock;
    private Ingredient sauceMock;
    private Ingredient fillingMock;

    @Before
    public void setUp() {
        burger = new Burger();

        // Мок булочки
        bunMock = mock(Bun.class);
        when(bunMock.getName()).thenReturn("Test Bun");
        when(bunMock.getPrice()).thenReturn(100f);

        // Мок соуса
        sauceMock = mock(Ingredient.class);
        when(sauceMock.getName()).thenReturn("Ketchup");
        when(sauceMock.getPrice()).thenReturn(50f);
        when(sauceMock.getType()).thenReturn(IngredientType.SAUCE);

        // Мок начинки
        fillingMock = mock(Ingredient.class);
        when(fillingMock.getName()).thenReturn("Beef");
        when(fillingMock.getPrice()).thenReturn(150f);
        when(fillingMock.getType()).thenReturn(IngredientType.FILLING);
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(bunMock);
        assertEquals(bunMock, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(sauceMock);
        assertEquals(1, burger.ingredients.size());
        assertEquals(sauceMock, burger.ingredients.get(0));
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(sauceMock);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(sauceMock);
        burger.addIngredient(fillingMock);
        burger.moveIngredient(0, 1);
        assertEquals(fillingMock, burger.ingredients.get(0));
        assertEquals(sauceMock, burger.ingredients.get(1));
    }

    @Test
    public void testGetPriceWithIngredients() {
        burger.setBuns(bunMock); // 100 * 2 = 200
        burger.addIngredient(sauceMock);   // 50
        burger.addIngredient(fillingMock); // 150
        float expected = 200 + 50 + 150;
        assertEquals(expected, burger.getPrice(), 0.001);
    }

    @Test
    public void testGetReceipt() {
        burger.setBuns(bunMock);
        burger.addIngredient(sauceMock);
        burger.addIngredient(fillingMock);

        String receipt = burger.getReceipt();

        assertTrue(receipt.contains("==== Test Bun ===="));
        assertTrue(receipt.contains("= sauce Ketchup ="));
        assertTrue(receipt.contains("= filling Beef ="));
        assertTrue(receipt.contains("Price:"));
    }
}