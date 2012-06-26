package ch.crisi.tdd.tictactoe;

public class TicTacToe {
    public STATE getWinner() {
        return winner;
    }

    public enum STATE {BLANK, CROSS, CIRCLE}

    private STATE[][] board = new STATE[3][3];
    private STATE winner = STATE.BLANK;

    public TicTacToe() {
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                board[x][y] = STATE.BLANK;
            }
        }
    }

    public boolean setCircle(int x, int y) {
        return set(x, y, STATE.CIRCLE);
    }

    private boolean set(int x, int y, STATE stateToSet) {
        if (board[x][y] == STATE.BLANK) {
            board[x][y] = stateToSet;

            checkForWinner(x, y, stateToSet);

            return true;
        }

        return false;
    }

    private void checkForWinner(int x, int y, STATE stateToSet) {
        checkForThreeInACol(y, stateToSet);
        checkForThreeInARow(x, stateToSet);
        checkForThreeInTheDiag(x, y, stateToSet);
        checkForThreeInTheAntiDiag(x, y, stateToSet);
    }

    private void checkForThreeInTheAntiDiag(int x, int y, STATE stateToSet) {
        if (x + y == 2) {
            for (int i = 0; i < board.length; i++) {
                if (anyCellInTheAntiDiag(i) != stateToSet) {
                    break;
                }

                if(i == 2) {
                    winner = stateToSet;
                }
            }
        }
    }

    private STATE anyCellInTheAntiDiag(int i) {
        return board[i][2 - i];
    }

    private void checkForThreeInTheDiag(int x, int y, STATE stateToSet) {
        if (x == y) {
            for (int i = 0; i < board.length; i++) {
                if (anyCellInTheDiag(i) != stateToSet) {
                    break;
                }

                if (i == 2) {
                    winner = stateToSet;
                }
            }
        }
    }

    private STATE anyCellInTheDiag(int i) {
        return board[i][i];
    }

    private void checkForThreeInARow(int x, STATE stateToSet) {
        for (int i = 0; i < board.length; i++) {
            if (anyCellInTheRow(x, i) != stateToSet) {
                break;
            }

            if (i == 2) {
                winner = stateToSet;
            }
        }
    }

    private STATE anyCellInTheRow(int x, int i) {
        return board[x][i];
    }

    private void checkForThreeInACol(int y, STATE stateToSet) {
        for (int i = 0; i < board.length; i++) {
            if (anyCellInTheCol(y, i) != stateToSet) {
                break;
            }

            if (i == 2) {
                winner = stateToSet;
            }
        }
    }

    private STATE anyCellInTheCol(int y, int i) {
        return board[i][y];
    }

    public boolean isCircle(int x, int y) {
        return board[x][y] == STATE.CIRCLE;
    }

    public boolean setCross(int x, int y) {
        return set(x, y, STATE.CROSS);
    }

    public boolean isCross(int x, int y) {
        return board[x][y] == STATE.CROSS;
    }

    public boolean isFinished() {
        return winner != STATE.BLANK;
    }
}
