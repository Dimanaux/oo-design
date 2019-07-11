package oo.java.lang;

public class ClassicIf {
    private final boolean condition;

    public ClassicIf(boolean condition) {
        this.condition = condition;
    }

    public ClassicIf then(Runnable then) {
        if (condition) {
            then.run();
        }
        return this;
    }

    public ClassicIf elseIf(boolean condition) {
        return new ClassicIf(condition);
    }

    public void otherwise(Runnable otherwise) {
        if (!condition) {
            otherwise.run();
        }
    }
}
