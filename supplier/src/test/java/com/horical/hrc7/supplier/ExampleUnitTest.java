package com.horical.hrc7.supplier;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void checkType() {
        int x = 5;
        Object t = x;
        assertFalse(t instanceof Integer);
    }

    @Test
    public void testGenericSuperClass() {
    }
}