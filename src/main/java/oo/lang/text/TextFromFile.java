package oo.lang.text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Scanner;

public class TextFromFile implements Text {
    private final AppendableText content = new AppendableText();

    public TextFromFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        scanner.forEachRemaining(string -> content.append(Text.of(string)));
    }

    @Override
    public int length() {
        return content.length();
    }

    @Override
    public void print(PrintStream stream) {
        content.print(stream);
    }

    @Override
    public Iterator<Character> iterator() {
        return content.iterator();
    }
}
