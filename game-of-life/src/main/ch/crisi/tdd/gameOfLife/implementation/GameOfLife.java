package ch.crisi.tdd.gameOfLife.implementation;

import ch.crisi.tdd.gameOfLife.AbstractGridView;
import ch.crisi.tdd.gameOfLife.Grid;

public class GameOfLife {

    public static void main(String[] args) {
        GameOfLife gol = new GameOfLife();
        gol.init();
    }

    private void init() {
        testConsoleView();
        testImageView();
    }

    private void testImageView() {
        Grid grid = new Grid(100);
        grid.fillGridRandomly();

        ImageGridView gv = new ImageGridView(grid);
        gv.setRefreshRate(100);
        gv.startRenderLoop();
    }

    private void testConsoleView() {
        Grid grid = new Grid(3);
        grid.fillGridWithLives();
        
        AbstractGridView gv = new ConsoleGridView(grid);
        gv.startRenderLoop();
    }

}
