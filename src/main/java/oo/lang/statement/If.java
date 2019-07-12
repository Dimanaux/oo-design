package oo.lang.statement;

import java.util.function.Supplier;
import java.util.Optional;

public class If<T> {
    private final boolean condition;
    private Optional<T> result = Optional.<T>empty();

    public If(boolean condition) {
        this.condition = condition;
    }

    private If(boolean condition, Optional<T> result) {
        this(condition);
        this.result = result;
    }

    public If then(Supplier<T> then) {
        if (condition && !result.isPresent()) {
            result = then.get();
        }
        return this;
    }

    public If elseIf(boolean condition) {
        return new If(condition, result);
    }

    public T otherwise(Runnable otherwise) {
        if (!result.isPresent()) {
            result = Optional.of(otherwise.get());
        }
        return result.orElseThrow(NotExhaustiveIfExpression::new);
    }
}
