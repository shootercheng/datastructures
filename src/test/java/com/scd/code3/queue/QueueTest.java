package com.scd.code3.queue;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author James Chen
 * @date 21/09/19
 */
public class QueueTest {

    @Test
    public void testOffer() {
        CircleSqQueue<String> circleSqQueue = new CircleSqQueue<>(6);
        try {
            circleSqQueue.offer("A");
            circleSqQueue.offer("B");
            circleSqQueue.offer("C");
            circleSqQueue.offer("D");
            circleSqQueue.offer("E");
            circleSqQueue.offer("F");
            Assert.assertEquals(6, circleSqQueue.length());
            circleSqQueue.offer("G");
            Assert.fail("bug-----------");
        } catch (Exception e) {
            Assert.assertEquals("queue is max size", e.getMessage());
        }
    }

    @Test
    public void testClearEmpty() throws Exception {
        CircleSqQueue<String> circleSqQueue = new CircleSqQueue<>(6);
        circleSqQueue.offer("A");
        circleSqQueue.offer("B");
        circleSqQueue.offer("C");
        circleSqQueue.clear();
        Assert.assertEquals(true, circleSqQueue.isEmpty());
    }

    @Test
    public void testLength() throws Exception {
        CircleSqQueue<String> circleSqQueue = new CircleSqQueue<>(6);
        circleSqQueue.offer("A");
        circleSqQueue.offer("B");
        circleSqQueue.offer("C");
        Assert.assertEquals(3, circleSqQueue.length());
    }

    @Test
    public void testPeek() throws Exception {
        CircleSqQueue<String> circleSqQueue = new CircleSqQueue<>(6);
        circleSqQueue.offer("A");
        circleSqQueue.offer("B");
        circleSqQueue.offer("C");
        Assert.assertEquals("A", circleSqQueue.peek());
    }

    @Test
    public void testPoll() throws Exception {
        CircleSqQueue<String> circleSqQueue = new CircleSqQueue<>(6);
        circleSqQueue.offer("A");
        circleSqQueue.offer("B");
        circleSqQueue.offer("C");
        Assert.assertEquals(3, circleSqQueue.length());
        Assert.assertEquals("A", circleSqQueue.poll());
        Assert.assertEquals(2, circleSqQueue.length());
        Assert.assertEquals("B", circleSqQueue.peek());
    }

    @Test
    public void testPoolOffer() throws Exception {
        CircleSqQueue<String> circleSqQueue = new CircleSqQueue<>(6);
        circleSqQueue.offer("A");
        circleSqQueue.offer("B");
        circleSqQueue.offer("C");
        circleSqQueue.offer("D");
        circleSqQueue.offer("E");
        circleSqQueue.offer("F");
        Assert.assertEquals("A", circleSqQueue.poll());
        circleSqQueue.offer("G");
        Assert.assertEquals("B", circleSqQueue.peek());
        circleSqQueue.disPlay();

    }
}
