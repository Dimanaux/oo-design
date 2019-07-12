package oo.lang.bool;

public class FalseClass extends Bool {
    public static final FalseClass False = new FalseClass();

    @Override
    public void control(If statement) {
        statement.otherwise();
    }
}

