package oo.lang.text;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TextTest {
    private StringWriter output;

    @Before
    public void createOutput() {
        output = new StringWriter();
    }

    @Test
    public void testConstructors() {
        Assert.assertEquals(5, Text.of("Hello").length());
        Assert.assertEquals(0, Text.of("").length());
        Assert.assertEquals(1, Text.of(" ").length());

        Text.of("Hello, world").print(output);
        Assert.assertEquals("Hello, world", output.toString());
    }

    @Test
    public void testReverse() {
        new Reversed(Text.of("aBcDeF")).print(output);
        Assert.assertEquals("FeDcBa", output.toString());
    }

    @Test
    public void testAppend() {
        AppendableText text = new AppendableText();
        text.append(Text.of("2"));
        text.append(Text.of("1"));
        text.append('3');
        text.print(output);
        Assert.assertEquals(3, text.length());
        Assert.assertEquals("213", output.toString());
    }

    @Test
    public void testAppend2() {
        AppendableText text = new AppendableText(Text.of("hell"));
        text.append('o').append(Text.of("!"));
        text.print(output);
        Assert.assertEquals("hello!", output.toString());
    }

    @Test
    public void testSubtext() {
        Text text = Text.of("original");
        Text sub = new PartOfText(text, 1, 5);
        sub.print(output);
        Assert.assertEquals(4, sub.length());
        Assert.assertEquals("rigi", output.toString());
    }

    @Test
    public void testSubtext2() {
        Text text = Text.of("sentence");
        Text sub = new PartOfText(text, 3);
        sub.print(output);
        Assert.assertEquals(5, sub.length());
        Assert.assertEquals("tence", output.toString());
    }
}
