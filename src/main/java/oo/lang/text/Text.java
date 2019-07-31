package oo.lang.text;

import java.io.IOException;
import java.io.PrintStream;
import java.io.Writer;

public interface Text extends Iterable<Character> {
    static Text of(String string) {
        return ImmutableText.of(string);
    }

    int length();

    default void print(Writer writer) {
        forEach(c -> {
            try {
                writer.write(c);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    default void print(PrintStream stream) {
        forEach(stream::print);
    }

    default void print() {
        print(System.out);
    }
}
