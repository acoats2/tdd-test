package ch.crisi.tdd.gameOfLife.implementation;

import ch.crisi.tdd.gameOfLife.AbstractGridView;
import ch.crisi.tdd.gameOfLife.Grid;

public class ConsoleGridView extends AbstractGridView {

    public ConsoleGridView(Grid grid) {
        super(grid);
    }

    @Override
    protected void repaint() {
    }

    @Override
    protected void onNextGeneration() {
        System.out.print("\n");
    }

    @Override
    protected void onNewLine() {
        System.out.print("\n");
    }

    @Override
    protected void renderDeadCell(int x, int y) {
        System.out.print("-");
    }

    @Override
    protected void renderLiveCell(int x, int y) {
        System.out.print("*");
    }
}