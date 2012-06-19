package ch.crisi.tdd.gameOfLife;

import java.awt.event.*;

public class GameOfLife implements MouseListener {

    private String state;

    public GameOfLife() {

    }

    public GameOfLife(String startingState) {
        //To change body of created methods use File | Settings | File Templates.
    }


    //try to use mvc

    public static void main(String[] args) {

        GameOfLife gol = new GameOfLife();
        gol.init();


    }

    private void init() {

        testConsoleView();

        testSwingView();


/*        JFrame frame = new JFrame("Game of Life");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        Container contentPane = frame.getContentPane();
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(new FlowLayout());
        contentPane.add(CellFactory.createLivingCell(this));

        frame.setVisible(true);*/
    }

    private void testSwingView() {
        Grid grid = new Grid(3);
        grid.fillGridWithLives();
        AbstractGridView gv = new SwingGridView(grid);
        gv.setTimeout(1000);
        gv.startRenderLoop();
    }

    private void testConsoleView() {
        Grid grid = new Grid(3);
        grid.fillGridWithLives();
        AbstractGridView gv = new ConsoleGridView(grid);
//        gv.setTimeout(1000);
        gv.startRenderLoop();
    }


    public void mouseClicked(MouseEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void mousePressed(MouseEvent e) {
        Object source = e.getSource();
        if (source instanceof Cell_) {
            ((Cell_)source).toggle();
        }
    }

    public void mouseReleased(MouseEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void mouseEntered(MouseEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void mouseExited(MouseEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setState(String state) {
        //To change body of created methods use File | Settings | File Templates.
    }

    public String getState() {
        return state;
    }
}
