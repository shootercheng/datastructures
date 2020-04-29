package com.scd.graph.adjList;

/**
 * @author James
 */
public class UnDirectedGraph extends BaseGraph {

    @Override
    public void addEdge(String sPoint, String tPoint) {
        int sIndex = locateVex(sPoint);
        int tIndex = locateVex(tPoint);
        addArc(sIndex, tIndex);
        addArc(tIndex, sIndex);
        edgeNum = edgeNum + 2;
    }
}
