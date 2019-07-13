package oo.lang.statement;

public class NotExhaustiveIfExpression extends RuntimeException {
    public NotExhaustiveIfExpression() {
        super();
    }

    public NotExhaustiveIfExpression(String message) {
        super(message);
    }
}
