package com.scd.graph.matrix;

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
     * 顶点名字
     */
    protected String[] vertex;

    /**
     * 邻接矩阵
     */
    protected int[][] adjMatrix;

    public BaseGraph() {
        System.out.println("init matrix graph data");
    }

    public void createGraph(String vertexs) {
        String[] vertex = vertexs.split(",\\s*");
        this.vertexNum = vertex.length;
        this.vertex = vertex;
        // 初始化邻接矩阵
        adjMatrix = new int[vertexNum][vertexNum];
        for (int i = 0; i < vertexNum; i++) {
            for (int j = 0; j < vertexNum; j++) {
                if (i == j) {
                    adjMatrix[i][j] = 0;
                } else {
                    adjMatrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
    }

    public void createGraph(List<String> vertexsList) {
        this.vertexNum = vertexsList.size();
        this.vertex = new String[vertexsList.size()];
        vertexsList.toArray(vertex);
        adjMatrix = new int[vertexNum][vertexNum];
        for (int i = 0; i < vertexNum; i++) {
            for (int j = 0; j < vertexNum; j++) {
                adjMatrix[i][j] = -1;
            }
        }
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
        return vertex[v];
    }

    public int locateVex(Object vex) {
        for (int i = 0; i < vertex.length; i++) {
            if (vertex[i].equals(vex.toString())) {
                return i;
            }
        }
        return -1;
    }

    public void printGraph() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < adjMatrix.length; i ++) {
            for (int j = 0; j < adjMatrix[i].length; j++) {
                stringBuilder.append(adjMatrix[i][j]).append(" ");
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
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
        for (int i = 0; i < vertexNum; i++) {
            if (adjMatrix[v][i] != -1) {
                return i;
            }
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
        for (int i = w + 1; i < vertexNum; i++) {
            if (adjMatrix[v][i] != -1) {
                return i;
            }
        }
        return -1;
    }
}
