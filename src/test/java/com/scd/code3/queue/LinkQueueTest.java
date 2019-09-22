package com.scd.code3.queue;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author James Chen
 * @date 22/09/19
 */
public class LinkQueueTest {

    @Test
    public void testOffer() {
        LinkQueue<String> linkQueue = new LinkQueue<>();
        try {
            linkQueue.offer("A");
            linkQueue.offer("B");
            linkQueue.offer("C");
            linkQueue.offer("D");
            Assert.assertEquals(4, linkQueue.length());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPeek() throws Exception {
        LinkQueue<String> linkQueue = new LinkQueue<>();
        linkQueue.offer("A");
        linkQueue.offer("B");
        linkQueue.offer("C");
        linkQueue.offer("D");
        Assert.assertEquals("A", linkQueue.peek());
    }

    @Test
    public void testPoll() throws Exception {
        LinkQueue<String> linkQueue = new LinkQueue<>();
        linkQueue.offer("A");
        linkQueue.offer("B");
        linkQueue.offer("C");
        linkQueue.offer("D");
        Assert.assertEquals(4, linkQueue.length());
        Assert.assertEquals("A", linkQueue.poll());
        Assert.assertEquals(3, linkQueue.length());
    }

    @Test
    public void testDisplay() throws Exception {
        LinkQueue<String> linkQueue = new LinkQueue<>();
        linkQueue.disPlay();
        linkQueue.offer("A");
        linkQueue.offer("B");
        linkQueue.offer("C");
        linkQueue.offer("D");
        linkQueue.disPlay();
    }

    public boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        Double n = Math.sqrt(num);
        for (int i = 2; i < n.intValue(); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testPrime() {
        Assert.assertEquals(true , isPrime(2));
        Assert.assertEquals(true , isPrime(3));
        Assert.assertEquals(true , isPrime(4));
        Assert.assertEquals(true , isPrime(6));
    }
}
