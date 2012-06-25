package ch.crisi.tdd.gameOfLife;

public class GameOfLife {

    public static void main(String[] args) {
        GameOfLife gol = new GameOfLife();
        gol.init();
    }

    private void init() {
        testConsoleView();
//        testSwingView();
        testImageView();
    }

    private void testImageView() {
        Grid grid = new Grid(100);
        grid.fillGridRandomly();
        ImageGridView gv = new ImageGridView(grid);
        gv.setRefreshRate(100);
        gv.startRenderLoop();
    }

    private void testSwingView() {
        Grid grid = new Grid(20);
        grid.fillGridRandomly();
        AbstractGridView gv = new SwingGridView(grid);
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
