package oo.lang.bool;

public class FalseClass implements Bool {
    public static final FalseClass False = new FalseClass();

    private FalseClass() {
    }

    @Override
    public void ifTrue(Runnable action) {
    }

    @Override
    public Bool and(Bool other) {
        return this;
    }

    @Override
    public Bool or(Bool other) {
        return other;
    }

    @Override
    public Bool negate() {
        return True;
    }
}
