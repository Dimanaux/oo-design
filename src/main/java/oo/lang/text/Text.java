package oo.lang.text;

import java.io.PrintStream;

public interface Text extends Iterable<Character> {
    int length();

    void print(PrintStream stream);

    default void print() {
        print(System.out);
    }

    default void println(PrintStream stream) {
        stream.print(this);
        stream.println();
    }

    default void println() {
        println(System.out);
    }
}
