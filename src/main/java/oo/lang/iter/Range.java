package oo.lang.iter;

import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Range<T> implements Iterable<T> {
    private T from;
    private Function<T, T> next;
    private Predicate<T> until;

    public Range() {
    }

    public Range(T initValue) {
        this.from = initValue;
    }

    public Range<T> from(T initValue) {
        this.from = initValue;
        return this;
    }

    public Range<T> to(T bound) {
        until = val -> val.equals(bound);
        return this;
    }

    public Range<T> until(Predicate<T> breakCondition) {
        this.until = breakCondition;
        return this;
    }

    public Range<T> with(Function<T, T> next) {
        this.next = next;
        return this;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            T currentValue = from;

            @Override
            public boolean hasNext() {
                return !until.test(currentValue);
            }

            @Override
            public T next() {
                T pred = currentValue;
                currentValue = next.apply(currentValue);
                return pred;
            }
        };
    }
}
