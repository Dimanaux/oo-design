package oo.lang.statement;

import org.junit.Assert;
import org.junit.Test;

import java.util.function.Supplier;

public class IfTest {
    private Supplier<Integer> zero = () -> 0;
    private Supplier<Integer> one = () -> 1;
    private Supplier<Integer> two = () -> 2;
    private Supplier<Integer> three = () -> 3;

    @Test
    public void testIfThenElseWithTrue() {
        Integer result = new If<Integer>(true)
                .then(one)
                .otherwise(two);
        Assert.assertEquals(one.get(), result);
    }

    @Test
    public void testIfThenElseWithFalse() {
        Integer result = new If<Integer>(false)
                .then(one)
                .otherwise(two);
        Assert.assertEquals(two.get(), result);
    }

    @Test
    public void testFirstElseIf() {
        Integer result =
                new If<Integer>(false).then(zero)
                        .elseIf(true).then(one)
                        .elseIf(false).then(two)
                        .otherwise(three);
        Assert.assertEquals(one.get(), result);
    }

    @Test
    public void fizzBuzz() {
        Integer i = 15;
        String result = new If<String>(i % 15 == 0)
                .then(() -> "FizzBuzz")
                .elseIf(i % 3 == 0).then(() -> "Fizz")
                .elseIf(i % 5 == 0).then(() -> "Buzz")
                .otherwise(i::toString);
        Assert.assertEquals("FizzBuzz", result);
    }
}
