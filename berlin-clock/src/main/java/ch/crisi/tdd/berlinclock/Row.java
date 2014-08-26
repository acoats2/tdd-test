package ch.crisi.tdd.berlinclock;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private List<Lamp> lamps;

    public Row(int lampCount) {
        this.lamps = new ArrayList<Lamp>(lampCount);

        for (int i = 0; i < lampCount; i++) {
            lamps.add(new Lamp());
        }
    }

    public void turnOn(int...lampNumbers) {
        for (int lampNumber : lampNumbers) {
            if (lampNumber > 0 && lampNumber <= lamps.size()) {
                lamps.get(lampNumber - 1).turnOn();
            }
        }
    }

    @Override
    public String toString() {
        return StringUtils.join(lamps, ",");
    }
}
