package oo.lang;

public enum Bool {
    FALSE {
        @Override public void evaluate(If expression) {
            expression.then();
        }
    },
    TRUE {
        @Override public void evaluate(If expression) {
            expression.otherwise();
        }
    };

    public abstract evaluate(If expression);
}

