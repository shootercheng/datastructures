package com.scd.graph.adjList;

/**
 * @author James
 * 图的顶点
 */
public class GraphNode {
    /**
     * 顶点名字
     */
    protected String vertex;

    /**
     * 指向第一条依附于该顶点的弧
     */
    protected ArcNode firstArcNode;

    public GraphNode(String vertex) {
        this.vertex = vertex;
    }

    public GraphNode(ArcNode firstArcNode) {
        this.firstArcNode = firstArcNode;
    }

    public GraphNode(String vertex, ArcNode firstArcNode) {
        this.vertex = vertex;
        this.firstArcNode = firstArcNode;
    }
}
