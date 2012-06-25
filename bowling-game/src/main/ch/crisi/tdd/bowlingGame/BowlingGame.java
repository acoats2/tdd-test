package ch.crisi.tdd.bowlingGame;

public class BowlingGame {
    private int[] rolls = new int[21];
    private int currentRoll = 0;
    private int score = 0;


    public void add(int pins) {
        rolls[currentRoll] = pins;
        currentRoll++;

    }

    public int getCurrentScore() {
        int score = 0;
        int firstRollInCurrentFrame = 0;

        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(firstRollInCurrentFrame)) {
                score += 10 + nextTwoRollsOfNextFrame(firstRollInCurrentFrame);
                firstRollInCurrentFrame++;
            } else if (isSpare(firstRollInCurrentFrame)) {
                score += 10 + nextRollOfNextFrame(firstRollInCurrentFrame);
                firstRollInCurrentFrame += 2;
            } else {
                score += rollsOfCurrentFrame(firstRollInCurrentFrame);
                firstRollInCurrentFrame += 2;
            }

        }


        return score;
    }

    private int rollsOfCurrentFrame(int firstRollInCurrentFrame) {
        return rolls[firstRollInCurrentFrame] + rolls[firstRollInCurrentFrame + 1];
    }

    private int nextRollOfNextFrame(int firstRollInFrame) {
        return rolls[firstRollInFrame + 2];
    }

    private int nextTwoRollsOfNextFrame(int firstRollInFrame) {
        return rolls[firstRollInFrame + 1] + rolls[firstRollInFrame + 2];
    }

    private boolean isStrike(int firstRollInFrame) {
        return rolls[firstRollInFrame] == 10;
    }

    private boolean isSpare(int firstRollInFrame) {
        return rolls[firstRollInFrame] + rolls[firstRollInFrame + 1] == 10;
    }
}
