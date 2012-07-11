package ch.crisi.tdd.percentEncoder.implementation;

import ch.crisi.tdd.percentEncoder.FizzBuzz;
import org.apache.commons.lang3.StringUtils;

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
