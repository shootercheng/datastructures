package com.scd.code4.seqstr;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author James Chen
 * @date 10/10/19
 */
public class BruteForceStrTest {

    @Test
    public void testIndexOfStr() {
        String mainStr = "JamesJacdsdJavaccdd";
        String matchStr = "Java";
        Assert.assertEquals(11, BruteForceStr.indexOfBf(mainStr, matchStr, 0));
        Assert.assertEquals(1, BruteForceStr.indexOfBf("Java", "a", 0));
        Assert.assertEquals(4, BruteForceStr.indexOfBf("Javas", "s", 0));
    }
}
