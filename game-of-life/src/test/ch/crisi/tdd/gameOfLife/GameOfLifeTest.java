package ch.crisi.tdd.gameOfLife;

import org.junit.*;

import static junit.framework.Assert.*;

public class GameOfLifeTest {

    @Test
    public void shouldCreateNewGameInstance() {
        GameOfLife gol = new GameOfLife();
        assertNotNull("", gol);
    }

  /*  @Test
    public void shouldCreateNewGameInstanceWithState() {
        String state = "---*---";
        ch.crisi.tdd.gameOfLife.GameOfLife gol = new ch.crisi.tdd.gameOfLife.GameOfLife(state);

        assertNotNull(gol);
    }

    @Test
    public void shouldSetStartingState() {
        String state = "---*---";
        ch.crisi.tdd.gameOfLife.GameOfLife gol = new ch.crisi.tdd.gameOfLife.GameOfLife();
        gol.setState(state);
        String actual = gol.getState();

        assertEquals(state, actual);
    }

    @Test
    public void cellWithFewerThanTwoAliveNeighboursShouldDie() {
        
    }*/
}
