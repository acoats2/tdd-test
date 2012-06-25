package ch.crisi.tdd.gameOfLife;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class ImageGridView extends AbstractGridView {

    private static final int CELL_SIZE = 3;

    private JFrame frame = new JFrame("ImageGridView");
    private BufferedImage image;

    public ImageGridView(Grid grid) {
        super(grid);

        image = new BufferedImage(grid.getSize() * CELL_SIZE, grid.getSize() * CELL_SIZE, BufferedImage.TYPE_INT_RGB);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(grid.getSize() * CELL_SIZE, grid.getSize() * CELL_SIZE);
        frame.setVisible(true);
        frame.add(new JLabel(new ImageIcon(image)));
    }

    @Override
    protected void repaint() {
        frame.repaint();
    }

    @Override
    protected void onNewLine() {
    }

    @Override
    protected void onNextGeneration() {
    }

    @Override
    protected void renderDeadCell(int x, int y) {
        drawCellInColor(x, y, COLOR_BLACK);
    }

    @Override
    protected void renderLiveCell(int x, int y) {
        drawCellInColor(x, y, COLOR_WHITE);
    }

    private void drawCellInColor(int x, int y, int color) {
        for (int i = 0; i < CELL_SIZE; i++) {
            for (int j = 0; j < CELL_SIZE; j++) {
                image.setRGB(x * CELL_SIZE + i, y * CELL_SIZE + j, color);
            }
        }
    }
}
