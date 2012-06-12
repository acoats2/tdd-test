package ch.crisi.tdd.gameOfLife;

import org.junit.*;

import static junit.framework.Assert.*;

public class GameOfLifeTest {

    @Test
    public void shouldCreateNewGameInstance() {
        GameOfLife gol = new GameOfLife();
        assertNotNull("", gol);
    }

}
