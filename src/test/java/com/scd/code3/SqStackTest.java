package com.scd.code3;

import com.scd.code3.stack.SqStack;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author chengdu
 * @date 2019/8/29.
 */
public class SqStackTest {

    @Test
    public void testPush(){
        SqStack<String> sqStack = new SqStack<>(3);
        sqStack.push("1");
        sqStack.push("2");
        sqStack.push("3");
        try {
            sqStack.push("4");
            Assert.fail("bug---------------");
        } catch (Exception e){
            Assert.assertEquals("current stack size " + 3, e.getMessage());
        }
    }

    @Test
    public void testPop(){
        SqStack<String> sqStack = new SqStack<>(3);
        sqStack.push("1");
        sqStack.push("2");
        sqStack.push("3");
        String e1 = sqStack.pop();
        Assert.assertEquals("3", e1);
        String e2 = sqStack.pop();
        Assert.assertEquals("2", e2);
        String e3 = sqStack.pop();
        Assert.assertEquals("1", e3);
        try {
            sqStack.pop();
        } catch (Exception e){
            Assert.assertEquals("stack bottom", e.getMessage());
        }
    }
}
