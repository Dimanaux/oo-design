package oo.lang;

import oo.lang.statement.If;

public enum Bool {
    FALSE {
        @Override
        public void evaluate(If expression) {
            expression.then();
        }
    },
    TRUE {
        @Override
        public void evaluate(If expression) {
            expression.otherwise();
        }
    };

    public abstract void evaluate(If expression);
}

