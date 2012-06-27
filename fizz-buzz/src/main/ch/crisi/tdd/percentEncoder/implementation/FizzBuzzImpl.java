package ch.crisi.tdd.percentEncoder.implementation;

import ch.crisi.tdd.percentEncoder.FizzBuzz;

public class FizzBuzzImpl {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.print(FizzBuzz.process(i) + " ");
        }
    }
    
}
