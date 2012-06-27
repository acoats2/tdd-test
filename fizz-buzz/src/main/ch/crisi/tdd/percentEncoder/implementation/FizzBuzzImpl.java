package ch.crisi.tdd.percentEncoder.implementation;

import ch.crisi.tdd.percentEncoder.FizzBuzz;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FizzBuzzImpl {

    public static void main(String[] args) {
        List<String> output = new ArrayList<String>();

        for (int i = -100; i < 100; i++) {
            output.add(FizzBuzz.process(i));
        }

        System.out.print(StringUtils.join(output, ", "));
    }
    
}
