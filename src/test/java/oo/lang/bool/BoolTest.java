package oo.lang.bool;

import org.junit.Assert;
import org.junit.Test;

import static oo.lang.bool.Bool.False;
import static oo.lang.bool.Bool.True;

public class BoolTest {
    @Test
    public void booleanNegationTest() {
        Assert.assertEquals(False, True.negate());
        Assert.assertEquals(True, False.negate());
    }

    @Test
    public void booleanAndTest() {
        Assert.assertEquals(False, False.and(False));
        Assert.assertEquals(False, False.and(True));
        Assert.assertEquals(False, True.and(False));
        Assert.assertEquals(True, True.and(True));
    }

    @Test
    public void booleanOrTest() {
        Assert.assertEquals(False, False.or(False));
        Assert.assertEquals(True, False.or(True));
        Assert.assertEquals(True, True.or(False));
        Assert.assertEquals(True, True.or(True));
    }

    @Test(expected = RuntimeException.class)
    public void trueCanRunAction() {
        True.onTrue(() -> {
            throw new RuntimeException();
        });
    }

    @Test
    public void falseCannotRunAction() {
        False.onTrue(() -> {
            throw new RuntimeException();
        });
    }
}
