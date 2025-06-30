package site.nomoreparties.stellarburgers.tests;

import org.junit.Test;
import site.nomoreparties.stellarburgers.page.Bun;

import static org.junit.Assert.*;

public class BunTest {

    @Test
    public void testBunGetNameAndPrice() {
        Bun bun = new Bun("white bun", 150);
        assertEquals("white bun", bun.getName());
        assertEquals(150, bun.getPrice(), 0.01);
    }
}