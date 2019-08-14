package com.scd.code1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author chengdu
 * @date 2019/8/14.
 */
public class ArrayTest {

    private int[] a = {5,2,4,3,1};

    @Test
    public void testMax(){
        int result = ArrayData.findMax(a);
        Assert.assertEquals(5, result);
    }

    @Test
    public void testMin(){
        int result = ArrayData.findMin(a);
        Assert.assertEquals(1, result);
    }

    @Test
    public void testReverse(){
        ArrayData.reverse(a);
        System.out.println(a);
    }

    @Test
    public void testBubbleSort(){
        ArrayData.bubbleSort(a);
    }
}
