package site.nomoreparties.stellarburgers.tests;

import org.junit.Test;
import site.nomoreparties.stellarburgers.page.Bun;

import static org.junit.Assert.*;

public class BunTest {

    @Test
    public void testGetName() {
        Bun bun = new Bun("Test Bun", 120f);
        assertEquals("Test Bun", bun.getName());
    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun("Test Bun", 120f);
        assertEquals(120f, bun.getPrice(), 0.001);
    }
}