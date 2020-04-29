package com.scd.graph;

import com.scd.code3.queue.LinkQueue;
import com.scd.graph.adjList.*;
import org.junit.Test;

import java.util.Queue;

/**
 * @author James
 */
public class AdjList {

    @Test
    public void testUnDirectedGraph() {
        BaseGraph baseGraph = new UnDirectedGraph();
        baseGraph.createGraph("A,B,C");
        baseGraph.addEdge("A", "B");
        System.out.println(baseGraph.getArcNum());
    }

    @Test
    public void testDirectedGraph() {
        BaseGraph baseGraph = new DirectedGraph();
        baseGraph.createGraph("A,B,C");
        baseGraph.addEdge("A", "B");
        baseGraph.addEdge("A", "C");
        System.out.println(baseGraph.getArcNum());
    }

    @Test
    public void testUnDirectedNetWork() {
        NetWork netWork = new UnDirectedNetWork();
        netWork.createGraph("A,B,C");
        netWork.addEdge("A", "B",  2);
        netWork.addEdge("A", "C",  2);
        System.out.println(netWork.getArcNum());
    }

    @Test
    public void testDirectedNetWork() {
        NetWork netWork = new DirectedNetWork();
        netWork.createGraph("A,B,C");
        netWork.addEdge("A", "B", 2);
        netWork.addEdge("A", "C", 2);
        System.out.println(netWork.getArcNum());
        int v = netWork.locateVex("A");
        int adjIndex = netWork.firstAdjVex(v);
        System.out.println(adjIndex + "_" + netWork.getVex(adjIndex));
        int nextAdjIndex = netWork.nextAdjVex(v, adjIndex);
        System.out.println(nextAdjIndex + "_" + netWork.getVex(nextAdjIndex));
    }

    @Test
    public void testLinkQueue() throws Exception {
        LinkQueue<String> linkQueue = new LinkQueue<>();
        linkQueue.offer("A");
        linkQueue.offer("B");
        System.out.println(linkQueue.poll());
        System.out.println(linkQueue.poll());
    }
}
