package oo.lang.statement;

public class If {
    private final boolean condition;
    private boolean done = false;

    public If(boolean condition) {
        this.condition = condition;
    }

    private If(boolean condition, boolean done) {
        this(condition);
        this.done = done;
    }

    public If then(Runnable then) {
        if (condition && !done) {
            then.run();
            done = true;
        }
        return this;
    }

    public If elseIf(boolean condition) {
        return new If(condition, done);
    }

    public void otherwise(Runnable otherwise) {
        if (!condition && !done) {
            otherwise.run();
            done = true;
        }
    }
}
