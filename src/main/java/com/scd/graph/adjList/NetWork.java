package com.scd.graph.adjList;

/**
 * @author James
 */
public class NetWork extends BaseGraph {

    public void addEdge(String sPoint, String tPoint, int weight) {
    }

    public void addArc(int sIndex, int tIndex, int weight) {
        GraphNode graphNode = graphNodes[sIndex];
        ArcNode arcNode = new ArcNode(tIndex, weight);
        arcNode.nextArcNode = graphNode.firstArcNode;
        graphNode.firstArcNode = arcNode;
    }
}
