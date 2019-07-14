package oo.lang.expression;

import oo.lang.bool.Bool;

import java.util.function.Supplier;

public interface If<T> {
    If<T> then(Supplier<? extends T> then);

    If<T> elseIf(Bool condition);

    T otherwise(Supplier<? extends T> otherwise);
}
