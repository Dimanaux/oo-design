package oo.lang.statement;

import oo.lang.bool.Bool;

public class IfStatement implements If {
    private Bool control;

    public IfStatement(Bool condition) {
        control = condition;
    }

    @Override
    public If then(Runnable then) {
        control.onTrue(then);
        return this;
    }

    @Override
    public If elseIf(Bool condition) {
        return new IfStatement(condition.and(control.negate()));
    }

    @Override
    public void otherwise(Runnable otherwise) {
        control.onFalse(otherwise);
    }
}
