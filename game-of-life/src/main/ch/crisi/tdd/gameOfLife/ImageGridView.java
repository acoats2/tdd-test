package ch.crisi.tdd.gameOfLife;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageGridView extends AbstractGridView {

    private BufferedImage image;
    private JFrame frame;

    public ImageGridView(Grid grid) {
        super(grid);

        frame = new JFrame() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                g.drawImage(image, 0, 0, null);
            }
        };
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(grid.getSize() * 5, grid.getSize() * 5);
        frame.setVisible(true);

        image = new BufferedImage(grid.getSize() * 5, grid.getSize() * 5, BufferedImage.TYPE_INT_RGB);
    }

    @Override
    protected void repaint() {
        frame.repaint();
    }

    @Override
    protected void onNewLine() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected void onNextGeneration() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected void renderDeadCell(int x, int y) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                image.setRGB(x * 5 + i, y * 5 + j, new Color(0, 0, 0).getRGB());
            }
        }
    }

    @Override
    protected void renderLiveCell(int x, int y) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                image.setRGB(x * 5 + i, y * 5 + j, new Color(0, 255, 0).getRGB());
            }
        }
    }
}
