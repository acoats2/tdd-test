package ch.crisi.tdd.gameOfLife;

public class ConsoleGridView extends AbstractGridView {

    @Override
    void draw() {
        for (int x = 0; x < grid.getSize(); x++) {
            for (int y = 0; y < grid.getSize(); y++) {
                if (grid.isAlive(x, y)) {
                    System.out.print("*");
                } else {
                    System.out.print("-");
                }

                if (y == grid.getSize() - 1) {
                    System.out.print("\n");
                }
            }
        }
    }
}
