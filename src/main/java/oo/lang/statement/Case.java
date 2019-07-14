package oo.lang.statement;

import oo.lang.bool.Bool;

/**
 * Integer a = 5;
 * Case.<String>of(a)
 * .when(3, () -> "It is three")
 * .when(4, () -> "It is four");
 *
 * Works similar to switch, but breaks
 * @param <T> matching value type.
 */
public class Case<T> {
    private final T originalValue;
    private Bool alreadyRun = Bool.False;

    private Case(T value) {
        this.originalValue = value;
    }

    public static <T> Case<T> of(T variable) {
        return new Case<T>(variable);
    }

    public Case<T> when(T condition, Runnable action) {
        Bool match = Bool.valueOf(originalValue.equals(condition));
        match.and(alreadyRun.negate())
                .onTrue(action);
        match.onTrue(() -> alreadyRun = Bool.True);
        return this;
    }
}
