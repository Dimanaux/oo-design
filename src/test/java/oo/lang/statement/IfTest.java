package oo.lang.statement;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IfTest {
    String nothing = "nothing happened.";
    String thenClause = "then clause was invoked.";
    String firstElseIfClause = "first elseIf clause was invoked.";
    String secondElseIfClause = "second elseIf clause was invoked.";
    String otherwiseClause = "otherwise clause was invoked.";

    private String state;

    private void setState(String newState) {
        state = newState;
    }

    @Before
    public void init() {
        setState(nothing);
    }

    @Test
    public void simpleIfTest() {
        new If(true).then(() -> {
            setState(thenClause);
        });
        Assert.assertEquals(thenClause, state);
    }

    @Test
    public void simpleIfWithFalseTest() {
        new If(false).then(() -> {
            setState(thenClause);
        });
        Assert.assertEquals(nothing, state);
    }

    @Test
    public void testOtherwiseWithTrueCondition() {
        new If(true).then(() -> {
            setState(thenClause);
        }).otherwise(() -> {
            setState(otherwiseClause);
        });
        Assert.assertEquals(thenClause, state);
    }

    @Test
    public void testOtherwiseWithFalseCondition() throws InterruptedException {
        new If(false).then(() -> {
            setState(thenClause);
        }).otherwise(() -> {
            setState(otherwiseClause);
        });
        Assert.assertEquals(otherwiseClause, state);
    }

    @Test
    public void testFirstElseIf() {
        new If(false).then(() -> {
            setState(thenClause);
        }).elseIf(true).then(() -> {
            setState(firstElseIfClause);
        }).elseIf(false).then(() -> {
            setState(secondElseIfClause);
        }).otherwise(() -> {
            setState(otherwiseClause);
        });
        Assert.assertEquals(firstElseIfClause, state);
    }

    @Test
    public void fizzBuzz() {
        Integer i = 15;
        new If(i % 15 == 0).then(() -> {
            setState("FizzBuzz");
        }).elseIf(i % 3 == 0).then(() -> {
            setState("Fizz");
        }).elseIf(i % 15 == 0).then(() -> {
            setState("Buzz");
        }).otherwise(() -> {
            setState(i.toString());
        });
        Assert.assertEquals("FizzBuzz", state);
    }
}
