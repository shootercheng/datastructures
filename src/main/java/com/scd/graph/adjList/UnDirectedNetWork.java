package com.scd.graph.adjList;

/**
 * @author James
 */
public class UnDirectedNetWork extends NetWork {

    @Override
    public void addEdge(String sPoint, String tPoint, int weight) {
        int sIndex = locateVex(sPoint);
        int tIndex = locateVex(tPoint);
        addArc(sIndex, tIndex, weight);
        addArc(tIndex, sIndex, weight);
        edgeNum = edgeNum + 2;
    }
}
