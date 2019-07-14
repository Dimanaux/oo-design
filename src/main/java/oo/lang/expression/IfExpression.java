package oo.lang.expression;

import oo.lang.bool.Bool;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

/**
 * IfExpression works similar to if, but it has return value
 * @param <T> return value type
 */
public class IfExpression<T> implements If<T> {
    private final Bool control;
    private Optional<? extends T> result = Optional.empty();

    public IfExpression(Bool condition) {
        control = condition;
    }

    @Override
    public If<T> then(Supplier<? extends T> then) {
        control.onTrue(() -> {
            result = Optional.of(then.get());
        });
        return this;
    }

    @Override
    public If<T> elseIf(Bool condition) {
        AtomicReference<IfExpression<T>> newIf
                = new AtomicReference<>(this);
        condition.onTrue(() -> {
            newIf.set(new IfExpression<T>(condition));
        });
        return newIf.get();
    }

    @Override
    public T otherwise(Supplier<? extends T> otherwise) {
        control.onFalse(() -> {
            result = Optional.of(otherwise.get());
        });
        // TODO: add special exception type
        return result.orElseThrow(RuntimeException::new);
    }
}