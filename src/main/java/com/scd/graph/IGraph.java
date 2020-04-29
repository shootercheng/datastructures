package com.scd.graph;

/**
 * 图的接口
 */
public interface IGraph {
    /**
     * 创建一个图
     */
    void createGraph();

    /**
     * 返回顶点数
     * @return
     */
    int getVexNum();

    /**
     * 返回边数
     * @return
     */
    int getArcNum();

    /**
     * 返回v表示结点的值， 0 <= v < vexNum
     * @param v
     * @return
     * @throws Exception
     */
    Object getVex(int v) throws Exception;

    /**
     * 给定顶点的值vex，返回其在图中的位置，如果图中不包含此顶点，则返回-1
     * @param vex
     * @return
     */
    int locateVex(Object vex);

    /**
     * 返回v的第一个邻接点，若v没有邻接点，则返回-1，其中0≤v<vexNum
     * @param v
     * @return
     * @throws Exception
     */
    int firstAdjVex(int v) throws Exception;

    /**
     * 返回v相对于w的下一个邻接点，若w是v的最后一个邻接点，则返回-1，其中0≤v, w<vexNum
     * @param v
     * @param w
     * @return
     * @throws Exception
     */
    int nextAdjVex(int v, int w) throws Exception;
}
