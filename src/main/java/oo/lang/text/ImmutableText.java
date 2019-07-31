package oo.lang.text;

import java.util.ArrayList;
import java.util.Iterator;

public class ImmutableText implements Text {
    private final ArrayList<Character> characters;

    private ImmutableText(int length) {
        characters = new ArrayList<>(length);
    }

    public ImmutableText(Text text) {
        this(text.length());
        text.forEach(characters::add);
    }

    public static ImmutableText of(String string) {
        ImmutableText text = new ImmutableText(string.length());
        string.chars().mapToObj(c -> (char) c).forEach(text.characters::add);
        return text;
    }

    @Override
    public int length() {
        return characters.size();
    }

    @Override
    public Iterator<Character> iterator() {
        return characters.iterator();
    }
}
