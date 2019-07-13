package oo.lang.bool;

import java.util.HashMap;
import java.util.Map;

public interface Bool {
    Bool False = FalseClass.False;
    Bool True = TrueClass.True;

    Map<Boolean, Bool> primitiveToObject
            = new HashMap<Boolean, Bool>(2) {{
        put(false, False);
        put(true, True);
    }};

    static Bool valueOf(boolean primitive) {
        return primitiveToObject.get(primitive);
    }

    void onTrue(Runnable action);

    Bool negate();

    Bool and(Bool other);

    Bool or(Bool other);

    default void onFalse(Runnable action) {
        this.negate().onTrue(action);
    }
}
