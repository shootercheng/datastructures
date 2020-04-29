package com.scd.graph.adjList;

/**
 * @author James
 * 图邻接表存储的边(弧) 节点类
 */
public class ArcNode {
    /**
     * 弧指向的顶点位置
     */
    protected int adjVex;

    /**
     * 边或弧的权重
     */
    protected int weight;

    /**
     * 指向下一条弧(边)
     */
    protected ArcNode nextArcNode;

    public ArcNode(int adjVex) {
        this.adjVex = adjVex;
    }

    public ArcNode(int adjVex, int weight) {
        this.adjVex = adjVex;
        this.weight = weight;
    }

    public ArcNode(int adjVex, int weight, ArcNode nextArcNode) {
        this.adjVex = adjVex;
        this.weight = weight;
        this.nextArcNode = nextArcNode;
    }
}
