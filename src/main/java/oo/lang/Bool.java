package oo.lang;

import oo.lang.statement.If;

public enum Bool {
    FALSE {
        @Override
        public void evaluate(If expression) {
            expression.otherwise();
        }
    },
    TRUE {
        @Override
        public void evaluate(If expression) {
            expression.then();
        }
    };

    public abstract void evaluate(If expression);
}
