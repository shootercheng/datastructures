package com.scd.graph.adjList;

/**
 * @author James
 */
public class DirectedGraph extends BaseGraph {

    @Override
    public void addEdge(String sPoint, String tPoint) {
        int sIndex = locateVex(sPoint);
        int tIndex = locateVex(tPoint);
        addArc(sIndex, tIndex);
        edgeNum = edgeNum + 1;
    }
}
