package oo.lang.statement;

import oo.lang.bool.Bool;

/**
 * SwitchStatement works is similar to Java switch,
 * but it adds 'break' to each case by default.
 * In other words, it doesn't let the execution flow
 * to fall through each case if one is true.
 */
public class SwitchStatement implements Switch {
    private Bool alreadyRun = Bool.False;

    @Override
    public Switch caseOf(Bool condition, Runnable action) {
        condition.and(alreadyRun.negate()).onTrue(action);
        condition.onTrue(() -> alreadyRun = Bool.True);
        return this;
    }

    @Override
    public void otherwise(Runnable action) {
        alreadyRun.negate().onTrue(action);
    }
}
