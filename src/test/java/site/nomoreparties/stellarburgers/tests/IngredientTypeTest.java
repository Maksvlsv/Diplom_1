package site.nomoreparties.stellarburgers.tests;

import org.junit.Test;
import site.nomoreparties.stellarburgers.page.IngredientType;

import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void testEnumValues() {
        IngredientType[] types = IngredientType.values();
        assertEquals(2, types.length);
    }

    @Test
    public void testToStringValues() {
        assertEquals("SAUCE", IngredientType.SAUCE.toString());
        assertEquals("FILLING", IngredientType.FILLING.toString());
    }

    @Test
    public void testValueOfSAUCE() {
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void testValueOfFILLING() {
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }
}