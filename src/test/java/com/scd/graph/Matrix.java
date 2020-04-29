package com.scd.graph;

import com.scd.graph.matrix.*;
import com.scd.graph.matrix.vo.DijkstraVO;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * @author James
 */
public class Matrix {

    @Test
    public void testUndircetdGraph() {
        MatrixGraphData undirctedGraph = new UnDirectedGraph();
        undirctedGraph.createGraph("A,B,C");
        undirctedGraph.addEdge("A","B");
        undirctedGraph.addEdge("A","C");
        undirctedGraph.printGraph();
    }

    @Test
    public void testDirectedGraph() {
        MatrixGraphData directedGraph = new DirectedGraph();
        directedGraph.createGraph("A,B,C");
        directedGraph.addEdge("A", "B");
        directedGraph.addEdge("A", "C");
        directedGraph.printGraph();
    }

    @Test
    public void testFindAdjVex() {
        MatrixGraphData undirctedGraph = new UnDirectedGraph();
        undirctedGraph.createGraph("A,B,C");
        undirctedGraph.addEdge("A","B");
        undirctedGraph.addEdge("A","C");
        int index = undirctedGraph.firstAdjVex(undirctedGraph.locateVex("A"));
        Assert.assertNotEquals(-1, index);
        Assert.assertEquals("B", undirctedGraph.getVex(index));
    }

    @Test
    public void testFindNextAdjVex() {
        MatrixGraphData undirctedGraph = new UnDirectedGraph();
        undirctedGraph.createGraph("A,B,C");
        undirctedGraph.addEdge("A","B");
        undirctedGraph.addEdge("A","C");
        int sPointIndex = undirctedGraph.locateVex("A");
        int index = undirctedGraph.firstAdjVex(sPointIndex);
        Assert.assertNotEquals(-1, index);
        int nextIndex = undirctedGraph.nextAdjVex(sPointIndex, index);
        Assert.assertNotEquals(-1, nextIndex);
        Assert.assertEquals("C", undirctedGraph.getVex(nextIndex));
    }

    @Test
    public void testDirectNetWork() {
        MartixNetworkData directNetWork = new DirectedNetwork();
        directNetWork.createGraph("A,B,C");
        directNetWork.addEdge("A", "B", 2);
        directNetWork.addEdge("A", "C", 5);
        directNetWork.printGraph();
    }

    @Test
    public void testUnDirectNetwork() {
        MartixNetworkData undirectNetWork = new UnDirectedNetwork();
        undirectNetWork.createGraph("A,B,C");
        undirectNetWork.addEdge("A","B", 2);
        undirectNetWork.addEdge("A","C", 5);
        undirectNetWork.printGraph();
    }

    @Test
    public void testPointListGraph() {
        MartixNetworkData undirectNetWork = new UnDirectedNetwork();
        List<String> pointList = Arrays.asList("A","B","C");
        undirectNetWork.createGraph(pointList);
        undirectNetWork.addEdge("A", "B", 2);
        undirectNetWork.addEdge("A", "C", 5);
        undirectNetWork.printGraph();
    }

    @Test
    public void testQueue() {
        Queue<String> strQueue = new ArrayDeque<>(10);
        strQueue.offer("A");
        strQueue.offer("B");
        strQueue.offer("C");
        System.out.println(strQueue.poll());
        System.out.println(strQueue.poll());
        System.out.println(strQueue.poll());
        System.out.println(strQueue.poll());
    }

    @Test
    public void testBfsTraverse() {
        MatrixGraphData baseGraph = new DirectedGraph();
        baseGraph.createGraph("A,B,C,D,E");
        baseGraph.addEdge("A", "B");
        baseGraph.addEdge("A", "C");
        baseGraph.addEdge("C", "D");
        baseGraph.addEdge("C", "E");
        baseGraph.addEdge("A", "D");
        baseGraph.printGraph();
        Traverse.bfsTraverse(baseGraph);
    }

    @Test
    public void testDfsTraverse() {
        MatrixGraphData baseGraph = new DirectedGraph();
        baseGraph.createGraph("A,B,C,D,E");
        baseGraph.addEdge("A", "B");
        baseGraph.addEdge("A", "C");
        baseGraph.addEdge("C", "D");
        baseGraph.addEdge("C", "E");
        baseGraph.addEdge("A", "D");
        baseGraph.printGraph();
        Traverse.dfsTraverse(baseGraph);
    }

    @Test
    public void testDirectNetWorkDijkstra() {
        DirectedNetwork directNetWork = new DirectedNetwork();
        directNetWork.createGraph("v1,v2,v3,v4,v5,v6");
        directNetWork.addEdge("v1", "v3", 10);
        directNetWork.addEdge("v1", "v5", 30);
        directNetWork.addEdge("v1", "v6", 100);
        directNetWork.addEdge("v2", "v3", 5);
        directNetWork.addEdge("v3", "v4", 50);
        directNetWork.addEdge("v4", "v6", 10);
        directNetWork.addEdge("v5", "v6", 60);
        directNetWork.addEdge("v5", "v4", 20);
        int[] distance = directNetWork.dijkstra(0);
        DijkstraVO dijkstraVO = directNetWork.dijkstraWithShortPath(0);
        int[] dis = dijkstraVO.getDistance();
        StringBuilder[] shortPaths = dijkstraVO.getShortPaths();
        for (int i = 0; i < dis.length; i++) {
            if (dis[i] == 0 || dis[i] == Integer.MAX_VALUE) {
                continue;
            }
            System.out.println(shortPaths[i] + "  " + dis[i]);
        }
        System.out.println(distance);
    }
}
