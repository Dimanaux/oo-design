package oo.lang.text;

import oo.lang.bool.Bool;

import java.util.Iterator;
import java.util.function.Consumer;

public class PartOfText implements Text {
    private final AppendableText content = new AppendableText();

    public PartOfText(Text text, int startPosition, int endPosition) {
        text.forEach(new Consumer<Character>() {
            int position = 0;

            @Override
            public void accept(Character character) {
                Bool.valueOf(startPosition <= position && position < endPosition)
                        .ifTrue(() ->
                                content.append(character)
                        );
                position += 1;
            }
        });
    }

    public PartOfText(Text text, int startPosition) {
        this(text, startPosition, text.length());
    }

    @Override
    public int length() {
        return content.length();
    }

    @Override
    public Iterator<Character> iterator() {
        return content.iterator();
    }
}
