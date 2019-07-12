package oo.lang.bool;

import java.util.HashMap;
import java.util.Map;

public abstract class Bool {
    public static final Bool False = FalseClass.False;
    public static final Bool True = TrueClass.True;

    private static final Map<Boolean, Bool> primitiveToObject;

    static {
        primitiveToObject = new HashMap<>(2);
        primitiveToObject.put(false, False);
        primitiveToObject.put(true, True);
    }

    public static Bool valueOf(boolean primitive) {
        return primitiveToObject.get(primitive);
    }

    private Bool() {
    }

    public abstract void control(If statement);
}

