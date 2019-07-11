package oo.lang.statement;

import oo.lang.Bool;

public class IfTest {
    public static void main(String[] args) {
        IfTest test = new IfTest();
        test.checkThen();
        test.checkElse();
    }

    private String state;

    private void setState(String state) {
        this.state = state;
    }

    private String ok = "then() was invoked.";
    private String fail = "otherwise() was invoked.";
    private String nothingHappened = "nothing happened.";

    private void checkThen() {
        setState(nothingHappened);
        new If(Bool.TRUE) {
            public void then() {
                setState(ok);
            }

            public void otherwise() {
                setState(fail);
            }
        };
        assert state.equals(ok) : "Expected then() to be invoked, but " + state;
    }

    private void checkElse() {
        setState(nothingHappened);
        new If(Bool.FALSE) {
            public void then() {
                setState(fail);
            }

            public void otherwise() {
                setState(ok);
            }
        };
        assert state.equals(ok) : "Expected otherwise() to be envoced, but " + state;
    }

    private void checkEmptyElse() {
        setState(nothingHappened);
        new If(Bool.TRUE) {
            public void then() {
                setState(ok);
            }
        };
        assert state.equals(ok) : "Expected then() to be invoked, but " + state;
    }

    private void checkEmptyElseWithFalse() {
        setState(nothingHappened);
        new If(Bool.FALSE) {
            public void then() {
                setState(fail);
            }
        };
        assert state.equals(nothingHappened) : "Nothing expected, but " + state;
    }
}
