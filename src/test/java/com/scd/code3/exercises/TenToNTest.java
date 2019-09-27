package com.scd.code3.exercises;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author James Chen
 * @date 27/09/19
 */
public class TenToNTest {

    @Test
    public void testConvert() {
        String result = TenToN.convertToN(2,2);
        Assert.assertEquals("10", result);
        Assert.assertEquals("101", TenToN.convertToN(5, 2));
        Assert.assertEquals("110", TenToN.convertToN(6, 2));
    }
}
