package com.scd.graph.matrix;

/**
 * @author James
 */
public abstract class MartixNetworkData extends BaseGraph {
    public abstract void addEdge(String sPoint, String tPoint, int weight);

    public abstract int[] dijkstra(int start);
}
