package ch.crisi.tdd.percentEncoder.implementation.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {

    @AfterReturning(pointcut = "execution(* ch.crisi.tdd.percentEncoder.FizzBuzz.process(..))", returning = "result")
    public void logResult(String result) {
        System.out.println(result);
    }

}
