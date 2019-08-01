package oo.lang.text;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AppendableText implements Text {
    private final List<Character> characters = new LinkedList<>();

    public AppendableText() {
    }

    public AppendableText(Text text) {
        append(text);
    }

    public AppendableText(Text text, Text appendix) {
        this(text);
        append(appendix);
    }

    public AppendableText append(Text text) {
        text.forEach(characters::add);
        return this;
    }

    public AppendableText append(Character character) {
        characters.add(character);
        return this;
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
