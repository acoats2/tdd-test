package ch.crisi.tdd.fizzBuzz.implementation;

import ch.crisi.tdd.fizzBuzz.FizzBuzz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FizzBuzzImpl {

    public static void main(String[] args) {
        for (int i = -100; i < 100; i++) {
            FizzBuzz.process(i);
        }
    }
    
}
