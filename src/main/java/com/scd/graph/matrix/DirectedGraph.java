package com.scd.graph.matrix;

/**
 * @author James
 */
public class DirectedGraph extends MatrixGraphData {

    public DirectedGraph() {
        System.out.println("init directed graph ....");
    }

    @Override
    public void addEdge(String sPoint, String tPoint) {
        int sIndex = locateVex(sPoint);
        int tIndex = locateVex(tPoint);
        adjMatrix[sIndex][tIndex] = 1;
        edgeNum = edgeNum + 1;
    }
}
