package oo.lang.text;

import java.io.Writer;

public class StringWriter extends Writer {
    private String string = "";

    @Override
    public void write(char[] cbuf, int off, int len) {
        string += new String(cbuf, off, len);
    }

    @Override
    public void flush() {}

    @Override
    public void close() {}

    @Override
    public String toString() {
        return string;
    }
}
