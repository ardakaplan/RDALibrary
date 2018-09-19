package com.ardakaplan.rdalibrary;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {


    @Test
    public void testConvertFahrenheitToCelsius() {
        int actual = TEst.sum(100, 20);

        int expected = 120;

        assertEquals("Conversion from celsius to fahrenheit failed", expected, actual);
    }
}