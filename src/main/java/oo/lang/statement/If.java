package oo.lang.statement;

public abstract class If {
    If(Bool control) {
        control.evaluate(this);
    }

    abstract void then();
    void otherwise() {}
}

