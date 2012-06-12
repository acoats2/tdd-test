package ch.crisi.tdd.gameOfLife.rules;

import ch.crisi.tdd.gameOfLife.Grid;

public interface Rule {

    public Grid applyRule(Grid grid);
}
