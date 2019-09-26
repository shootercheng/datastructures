package com.scd.code3.stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author James Chen
 * @date 26/09/19
 */
public class LinkStackTest {

    @Test
    public void testPush() {
        LinkStack<Integer> integerLinkStack = new LinkStack<>();
        integerLinkStack.push(1);
        integerLinkStack.push(2);
        integerLinkStack.push(3);
        Assert.assertEquals(3, integerLinkStack.length());
    }

    @Test
    public void testPeekPop() {
        LinkStack<String> linkStack = new LinkStack<>();
        linkStack.push("A");
        linkStack.push("B");
        linkStack.push("C");
        Assert.assertEquals("C", linkStack.peek());
        Assert.assertEquals(3, linkStack.length());
        Assert.assertEquals("C", linkStack.pop());
        Assert.assertEquals(2, linkStack.length());
    }
}
