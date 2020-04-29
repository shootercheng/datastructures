package com.scd.graph.matrix;

/**
 * @author James
 */
public class UnDirectedNetwork extends MartixNetworkData {
    @Override
    public void addEdge(String sPoint, String tPoint, int weight) {
        int sIndex = locateVex(sPoint);
        int pIndex = locateVex(tPoint);
        // 无向图邻接矩阵对称
        adjMatrix[sIndex][pIndex] = adjMatrix[pIndex][sIndex] = weight;
    }

    @Override
    public int[] dijkstra(int start) {
        return new int[0];
    }
}
