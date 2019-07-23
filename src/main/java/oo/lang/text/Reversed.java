package oo.lang.text;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.LinkedList;

public class Reversed implements Text {
    private final LinkedList<Character> characters = new LinkedList<>();

    public Reversed(Text text) {
        text.forEach(characters::addFirst);
    }

    @Override
    public Iterator<Character> iterator() {
        return characters.iterator();
    }

    @Override
    public int length() {
        return characters.size();
    }

    @Override
    public void print(PrintStream stream) {
        characters.forEach(stream::print);
    }
}
