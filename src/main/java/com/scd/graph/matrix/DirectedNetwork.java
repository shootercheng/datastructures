package com.scd.graph.matrix;

import com.scd.graph.matrix.vo.DijkstraVO;

/**
 * @author James
 */
public class DirectedNetwork extends MartixNetworkData {

    @Override
    public void addEdge(String sPoint, String tPoint, int weight) {
        int sIndex = locateVex(sPoint);
        int tIndex = locateVex(tPoint);
        adjMatrix[sIndex][tIndex] = weight;
    }

    @Override
    public int[] dijkstra(int start) {
        if (start < 0 || start >= vertexNum) {
            throw new IllegalArgumentException("input num out of index");
        }
        boolean[] finds = new boolean[vertexNum];
        int[] distance = new int[vertexNum];
        // 初始化距离
        for (int i = 0; i < vertexNum; i++) {
            distance[i] = adjMatrix[start][i];
        }
        finds[start] = true;
        for (int i = 0; i < vertexNum; i++) {
            // 寻找距离中最短的
            int min = Integer.MAX_VALUE;
            int index = -1;
            StringBuilder minPath = new StringBuilder();
            for (int j = 0; j < vertexNum; j++) {
                // 从源点最短路径未找到
                if (!finds[j]) {
                    if (distance[j] < min) {
                        min = distance[j];
                        index = j;
                    }
                }
            }
            if (index != -1) {
                finds[index] = true;
                for (int j = 0; j < vertexNum; j++) {
                    if (!finds[j]) {
                        int curLen = adjMatrix[index][j];
                        if (curLen != Integer.MAX_VALUE && curLen != 0) {
                            int pathLen = min + curLen;
                            if (pathLen < distance[j]) {
                                distance[j] = pathLen;
                            }
                        }
                    }
                }
            }
        }
        return distance;
    }


    public DijkstraVO dijkstraWithShortPath(int start) {
        if (start < 0 || start >= vertexNum) {
            throw new IllegalArgumentException("input num out of index");
        }
        DijkstraVO dijkstraVO = new DijkstraVO();
        boolean[] finds = new boolean[vertexNum];
        int[] distance = new int[vertexNum];
        dijkstraVO.setDistance(distance);
        // 初始化距离
        for (int i = 0; i < vertexNum; i++) {
            distance[i] = adjMatrix[start][i];
        }
        StringBuilder[] shortPaths = initShortPaths(vertexNum, start, distance);
        dijkstraVO.setShortPaths(shortPaths);
        finds[start] = true;
        for (int i = 0; i < vertexNum; i++) {
            // 寻找距离中最短的
            int min = Integer.MAX_VALUE;
            int index = -1;
            StringBuilder minPath = new StringBuilder();
            for (int j = 0; j < vertexNum; j++) {
                // 从源点最短路径未找到
                if (!finds[j]) {
                    if (distance[j] < min) {
                        min = distance[j];
                        index = j;
                        String targetNode = vertex[j];
                        minPath = shortPaths[j];
                        if (minPath.lastIndexOf(targetNode) != minPath.length() - targetNode.length()) {
                            minPath = shortPaths[j].append(",").append(targetNode);
                        }
                    }
                }
            }
            if (index != -1) {
                finds[index] = true;
                for (int j = 0; j < vertexNum; j++) {
                    if (!finds[j]) {
                        int curLen = adjMatrix[index][j];
                        if (curLen != Integer.MAX_VALUE && curLen != 0) {
                            int pathLen = min + curLen;
                            if (pathLen < distance[j]) {
                                distance[j] = pathLen;
                                shortPaths[j] = new StringBuilder(minPath).append(",").append(vertex[j]);
                            }
                        }
                    }
                }
            }
        }
        return dijkstraVO;
    }

    private StringBuilder[] initShortPaths(int vertexNum, int start, int[] distance) {
        StringBuilder[] result = new StringBuilder[vertexNum];
        for (int i = 0; i < vertexNum; i++) {
            if (i == start || distance[i] == Integer.MAX_VALUE) {
                result[i] = new StringBuilder();
            } else {
                result[i] = new StringBuilder(vertex[start]);
            }
        }
        return result;
    }
}
