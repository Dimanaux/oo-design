public abstract class If {
    If(boolean condition) {
        // TODO: refactor
        if (condition) {
            then();
        } else {
            otherwise();
        }
    }

    abstract void then();
    void otherwise() {}
}
