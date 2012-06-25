package ch.crisi.tdd.bowlingGame;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class BowlingGameTest {

    private BowlingGame bg;

    @Before
    public void setUp() throws Exception {
        bg = new BowlingGame();

    }

    @Test
    public void canRollGutterBall() {
        bg.add(0);

        assertEquals(0, bg.getCurrentScore());
    }

    @Test
    public void canHitPins() {
        bg.add(1);
        bg.add(3);

        assertEquals(4, bg.getCurrentScore());
    }

    @Test
    public void canRollSpare() {
        rollSpare();
        bg.add(2);
        assertEquals(14, bg.getCurrentScore());
    }

    @Test
    public void canRollStrike() {
        rollStrikes(1);
        bg.add(3);
        bg.add(3);

        assertEquals(22, bg.getCurrentScore());
    }

    @Test
    public void canPlayPerfectGame() {
        rollStrikes(12);

        assertEquals(300, bg.getCurrentScore());
    }

    private void rollStrikes(int timesToRoll) {
        for(int i = 0; i < timesToRoll; i++) {
            bg.add(10);
        }
    }

    private void rollSpare() {
        bg.add(5);
        bg.add(5);
    }

}