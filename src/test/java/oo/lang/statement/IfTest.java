package oo.lang.statement;

import java.util.Arrays;

import oo.lang.Bool;

public class IfTest {
    public static void main(String[] args) {
        IfTest test = new IfTest();
        test.checkThen();
        test.checkElse();
    }

    Object whenThen = new Object();
    Object whenElse = new Object();

    public void checkThen() {
        Object result;
        new If(Bool.TRUE) {
            public void then() {
                result = whenThen;
            }
            public void otherwise() {
                result = whenElse;
            }
        };
        assert result == whenThen : "Expected then() invocation in If(TRUE)";
    }

    public void checkElse() {
        Object result;
        new If(Bool.TRUE) {
            public void then() {
                result = whenThen;
            }
            public void otherwise() {
                result = whenElse;
            }
        };
        assert result == whenElse : "Expected otherwise() invocation in If(FALSE)";
    }
}

