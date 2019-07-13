package oo.lang.statement;

import java.util.function.Supplier;
import java.util.Optional;

public class If<T> {
    private final boolean condition;
    private Optional<? extends T> result = Optional.empty();

    public If(boolean condition) {
        this.condition = condition;
    }

    private If(boolean condition, Optional<? extends T> result) {
        this(condition);
        this.result = result;
    }

    public If<T> then(Supplier<? extends T> then) {
        if (condition && !result.isPresent()) {
            result = Optional.of(then.get());
        }
        return this;
    }

    public If<T> elseIf(boolean condition) {
        return new If<T>(condition, result);
    }

    public T otherwise(Supplier<? extends T> otherwise) {
        if (!result.isPresent()) {
            result = Optional.of(otherwise.get());
        }
        return result.orElseThrow(NotExhaustiveIfExpression::new);
    }
}
