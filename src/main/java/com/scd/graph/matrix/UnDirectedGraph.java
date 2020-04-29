package com.scd.graph.matrix;


/**
 * 无向图，邻接矩阵对称
 * @author James
 */
public class UnDirectedGraph extends MatrixGraphData {

    public UnDirectedGraph() {
        System.out.println("init undirected graph....");
    }

    @Override
    public void addEdge(String sPoint, String tPoint) {
        int sLocate = locateVex(sPoint);
        int tLocate = locateVex(tPoint);
        // 无向图， 邻接矩阵对称
        adjMatrix[sLocate][tLocate] = adjMatrix[tLocate][sLocate] = 1;
        edgeNum = edgeNum + 2;
    }
}
