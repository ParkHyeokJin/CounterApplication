package com.counter;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void spaceMethodTest(){
        MainActivity main = new MainActivity();
        assertEquals(main.spaceToZero(3, "0", 3), "003");
        assertEquals(main.spaceToZero(13, "0", 3), "013");
        assertEquals(main.spaceToZero(113, "0", 3), "113");
    }
}