package ch.crisi.tdd.berlinclock;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private List<Lamp> lamps;

    public Row(int lampCount, Color color) {
        this.lamps = new ArrayList<Lamp>(lampCount);

        for (int i = 0; i < lampCount; i++) {
            lamps.add(new Lamp(color));
        }
    }

    /**
     * Turns on all lamps from left to right to the given lamp number.
     * @param lampNumber Count of lamps to turn on.
     */
    public void turnOn(int lampNumber) {
        if (lampNumber >= 0 && lampNumber <= lamps.size()) {
            for (int i = 0; i < lamps.size(); i++) {
                if (i < lampNumber) {
                    lamps.get(i).turnOn();
                } else {
                    lamps.get(i).turnOff();
                }
            }
        }
    }

    @Override
    public String toString() {
        return StringUtils.join(lamps, ",");
    }

    public void changeColor(Color color, int...lampNumbers) {
        for (int lampNumber : lampNumbers) {
            if (lampNumber > 0 && lampNumber < lamps.size()) {
                lamps.get(lampNumber - 1).setColor(color);
            }
        }
    }
}
