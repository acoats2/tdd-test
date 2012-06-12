package ch.crisi.tdd.gameOfLife;

import javax.swing.*;
import java.awt.*;
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
        JFrame frame = new JFrame("Game of Life");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        Container contentPane = frame.getContentPane();
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(new FlowLayout());
        contentPane.add(CellFactory.createLivingCell(this));

        frame.setVisible(true);
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
