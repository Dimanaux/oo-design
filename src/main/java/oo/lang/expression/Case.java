package oo.lang.expression;

import oo.lang.bool.Bool;

import java.util.Optional;
import java.util.function.Supplier;

public class Case<T> implements Switch<T> {
    private final T control;
    private Optional<? extends T> result = Optional.empty();

    public Case(T control) {
        this.control = control;
    }

    public static <T> Case<T> of(T control) {
        return new Case<>(control);
    }

    public Case<T> when(T value, Supplier<? extends T> expression) {
        Bool match = Bool.valueOf(control.equals(value));
        match.and(notUtilized()).onTrue(() -> {
            result = Optional.of(expression.get());
        });
        return this;
    }

    public T otherwise(Supplier<? extends T> expression) {
        notUtilized().onTrue(() -> {
            result = Optional.of(expression.get());
        });
        return result.orElseThrow(RuntimeException::new);
    }

    private Bool notUtilized() {
        return Bool.valueOf(result.isPresent()).negate();
    }
}
