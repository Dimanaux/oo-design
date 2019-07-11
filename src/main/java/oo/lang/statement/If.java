package oo.lang.statement;

import oo.lang.Bool;

public abstract class If {
    If(Bool control) {
        control.evaluate(this);
    }

    public abstract void then();

    public void otherwise() {
    }
}
