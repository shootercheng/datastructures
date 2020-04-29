package com.scd.graph.adjList;

import java.util.List;

/**
 * @author James
 */
public class BaseGraph {

    /**
     * 顶点数
     */
    protected int vertexNum;

    /**
     * 边数
     */
    protected int edgeNum;

    /**
     * 图的顶点集合
     */
    protected GraphNode[] graphNodes;

    /**
     * 创建图
     * @param vertex 顶点集合
     */
    public void createGraph(String vertex) {
        String[] vertexArr = vertex.split(",");
        vertexNum = vertexArr.length;
        graphNodes = new GraphNode[vertexNum];
        for (int i = 0; i < vertexNum; i++) {
            graphNodes[i] = new GraphNode(vertexArr[i]);
        }
    }

    /**
     * 创建图
     * @param vertexsList 顶点List集合
     */
    public void createGraph(List<String> vertexsList) {
        vertexNum = vertexsList.size();
        graphNodes = new GraphNode[vertexNum];
        for (int i = 0; i < vertexNum; i++) {
            graphNodes[i] = new GraphNode(vertexsList.get(i));
        }
    }

    public void addEdge(String sPoint, String tPoint) {
    }

    /**
     * 增加弧
     * @param sIndex sIndex
     * @param tIndex tIndex
     */
    public void addArc(int sIndex, int tIndex) {
        GraphNode graphNode = graphNodes[sIndex];
        ArcNode arcNode = new ArcNode(tIndex);
        arcNode.nextArcNode = graphNode.firstArcNode;
        graphNode.firstArcNode = arcNode;
    }

    public int getVexNum() {
        return vertexNum;
    }

    public int getArcNum() {
        return edgeNum;
    }


    public Object getVex(int v) {
        if (v < 0 || v >= vertexNum) {
            throw new IllegalArgumentException("out of array index range");
        }
        return graphNodes[v].vertex;
    }

    public int locateVex(Object vex) {
        for (int i = 0; i < vertexNum; i++) {
            if (graphNodes[i].vertex.equals(vex.toString())) {
                return i;
            }
        }
        return -1;
    }

    public void printGraph() {
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i < vertexNum; i ++) {
//            GraphNode graphNode = graphNodes[i];
//            stringBuilder.append(graphNode.vertex).append("->");
//            while (graphNode.firstArcNode != null) {
//                int adjVex = graphNode.firstArcNode.adjVex;
//                graphNode = graphNodes[adjVex];
//                stringBuilder.append(adjVex);
//            }
//            stringBuilder.append("^");
//            stringBuilder.append("\n");
//        }
//        System.out.println(stringBuilder);
    }

    /**
     * 返回v的第一个邻接点，若v没有邻接点，则返回-1，其中0≤v<vexNum
     * @param v
     * @return
     * @throws Exception
     */
    public int firstAdjVex(int v) {
        if (v < 0 || v >= vertexNum) {
            throw new IllegalArgumentException("out of array index range");
        }
        GraphNode graphNode = graphNodes[v];
        if (graphNode.firstArcNode != null) {
            return graphNode.firstArcNode.adjVex;
        }
        return -1;
    }

    /**
     * 返回v相对于w的下一个邻接点，若w是v的最后一个邻接点，则返回-1，其中0≤v, w<vexNum
     * @param v
     * @param w
     * @return
     * @throws Exception
     */
    public int nextAdjVex(int v, int w) {
        if (v < 0 || v >= vertexNum) {
            throw new IllegalArgumentException("out of array index range");
        }
        if (w < 0 || w >= vertexNum) {
            throw new IllegalArgumentException("out of array index range");
        }
        GraphNode graphNode = graphNodes[v];
        ArcNode nextArcNode = graphNode.firstArcNode;
        if (nextArcNode != null) {
            int adjVex = nextArcNode.adjVex;
            if (adjVex != w) {
                throw new IllegalArgumentException("graph connect error");
            }
        }
        ArcNode arcNode = nextArcNode.nextArcNode;
        if (arcNode != null) {
            return arcNode.adjVex;
        }
        return -1;
    }
}
