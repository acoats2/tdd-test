package ch.crisi.tdd.tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TicTacToeTest {

    private TicTacToe t;

    @Before
    public void setUp() {
        t = new TicTacToe();
    }


    @Test
    public void setCircle() {
        t.setCircle(1, 1);

        assertEquals(true, t.isCircle(1, 1));
    }

    @Test
    public void setCircleOnBlank() {
        boolean circlePlaced = t.setCircle(1, 1);

        assertEquals(true, circlePlaced);
    }

    @Test
    public void setCircleOnCircle() {
        t.setCircle(1, 1);
        boolean circlePlaced = t.setCircle(1, 1);

        assertEquals(false, circlePlaced);
    }

    @Test
    public void setCross() {
        t.setCross(1, 1);

        assertEquals(true, t.isCross(1, 1));
    }

    @Test
    public void setCrossOnBlank() {
        boolean crossPlaced = t.setCross(1, 1);

        assertEquals(true, crossPlaced);
    }

    @Test
    public void setCrossOnOccupied() {
        t.setCross(1, 1);
        boolean crossPlaced = t.setCross(1, 1);

        assertEquals(false, crossPlaced);
    }

    @Test
    public void threeInAColWins() {
        t.setCircle(0, 0);
        t.setCircle(1, 0);
        t.setCircle(2, 0);

        assertEquals(true, t.isFinished());
    }

    @Test
    public void threeInARowWins() {
        t.setCircle(0, 0);
        t.setCircle(0, 1);
        t.setCircle(0, 2);

        assertEquals(true, t.isFinished());
    }

    @Test
    public void threeInTheDiag() {
        t.setCircle(0, 0);
        t.setCircle(1, 1);
        t.setCircle(2, 2);

        assertEquals(true, t.isFinished());
    }

    @Test
    public void threeInTheAntiDiag() {
        t.setCircle(0, 2);
        t.setCircle(1, 1);
        t.setCircle(2, 0);

        assertEquals(true, t.isFinished());
    }

    @Test
    public void getWinner() {
        t.setCircle(0,0);
        t.setCircle(1,1);
        t.setCircle(2,2);

        assertEquals(TicTacToe.STATE.CIRCLE, t.getWinner());
    }
}
