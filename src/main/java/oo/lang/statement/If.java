package oo.lang.statement;

import oo.lang.bool.Bool;

public interface If {
    If then(Runnable then);
    If elseIf(Bool condition);
    void otherwise(Runnable otherwise);
}
