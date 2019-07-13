package oo.lang.bool;

public class TrueClass implements Bool {
    public static final TrueClass True = new TrueClass();

    private TrueClass() {
    }

    @Override
    public void onTrue(Runnable action) {
        action.run();
    }

    @Override
    public Bool and(Bool other) {
        return other;
    }

    @Override
    public Bool or(Bool other) {
        return this;
    }

    @Override
    public Bool negate() {
        return False;
    }
}
