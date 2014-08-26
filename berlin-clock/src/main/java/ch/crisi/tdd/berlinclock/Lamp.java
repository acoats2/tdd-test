package ch.crisi.tdd.berlinclock;


public class Lamp {
    private boolean on;

    public Lamp() {
        this.on = false;
    }

    public Lamp(boolean on) {
        this.on = on;
    }

    @Override
    public String toString() {
        if (this.on) {
            return "1";
        } else {
            return "0";
        }
    }

    public void turnOn() {
        this.on = true;
    }
}
