package oo.lang.statement;

import oo.lang.bool.Bool;

public interface Switch {
    Switch caseOf(Bool condition, Runnable action);
    void otherwise(Runnable action);
}
