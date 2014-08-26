package ch.crisi.tdd.berlinclock;

public class BerlinClock {
    private Row firstHoursRow;
    private Row secondHoursRow;
    private Row firstMinutesRow;
    private Row secondMinutesRow;

    public BerlinClock() {
        firstHoursRow = new Row(4);
        secondHoursRow = new Row(4);
        firstMinutesRow = new Row(11);
        secondMinutesRow = new Row(4);
    }

    public void setHour(int hour) {
        int fiveHours = hour / 5;
        int rest = hour % 5;

        for (int i = 1; i <= fiveHours; i++) {
            firstHoursRow.turnOn(i);
        }

        for (int i = 1; i <= rest; i++) {
            secondHoursRow.turnOn(i);
        }
    }


    public Row getSecondHoursRow() {
        return secondHoursRow;
    }

    public Row getFirstHoursRow() {
        return firstHoursRow;
    }
}
