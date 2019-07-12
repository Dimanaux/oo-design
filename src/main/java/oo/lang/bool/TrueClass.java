package oo.lang.bool;

public class TrueClass extends Bool {
    public static final TrueClass True = new TrueClass();

    @Override
    public void control(If statement) {
        statement.then();
    }
}

