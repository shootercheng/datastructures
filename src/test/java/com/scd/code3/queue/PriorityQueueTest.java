package com.scd.code3.queue;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author James Chen
 * @date 23/09/19
 */
public class PriorityQueueTest {

    @Test
    public void testOffer() throws Exception{
        PriorityQueue<PriorityData<String>> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new PriorityData<>("A", 1));
        priorityQueue.offer(new PriorityData<>("C", 3));
        priorityQueue.offer(new PriorityData<>("B", 2));
        priorityQueue.offer(new PriorityData<>("B1", 2));
        Assert.assertEquals(4, priorityQueue.length());
    }

    @Test
    public void testClearEmpty() throws Exception {
        PriorityQueue<PriorityData<String>> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new PriorityData<>("A", 1));
        priorityQueue.offer(new PriorityData<>("C", 3));
        priorityQueue.offer(new PriorityData<>("B", 2));
        priorityQueue.offer(new PriorityData<>("B1", 2));
        priorityQueue.clear();
        Assert.assertEquals(true, priorityQueue.isEmpty());
    }

    @Test
    public void testPeek() throws Exception {
        PriorityQueue<PriorityData<String>> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new PriorityData<>("A", 1));
        priorityQueue.offer(new PriorityData<>("C", 3));
        priorityQueue.offer(new PriorityData<>("B", 2));
        priorityQueue.offer(new PriorityData<>("B1", 2));
        Assert.assertEquals(new PriorityData<>("C", 3), priorityQueue.peek());
    }

    @Test
    public void testPoll() throws Exception {
        PriorityQueue<PriorityData<String>> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new PriorityData<>("A", 1));
        priorityQueue.offer(new PriorityData<>("C", 3));
        priorityQueue.offer(new PriorityData<>("B", 2));
        priorityQueue.offer(new PriorityData<>("B1", 2));
        Assert.assertEquals(new PriorityData<>("C", 3), priorityQueue.poll());
        Assert.assertEquals(new PriorityData<>("B", 2), priorityQueue.poll());
        Assert.assertEquals(new PriorityData<>("B1", 2), priorityQueue.poll());
        Assert.assertEquals(new PriorityData<>("A", 1), priorityQueue.poll());
        Assert.assertEquals(null, priorityQueue.poll());
    }
}
