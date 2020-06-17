package com.scd.graph.matrix;

import com.scd.graph.matrix.vo.DijkstraVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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


    public DijkstraVO dijkstraWithShortPath(String startPoint) {
        int start = locateVex(startPoint);
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

    public DijkstraVO dijkstraWithManyShortPath(String startPoint) {
        int start = locateVex(startPoint);
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
        Map<Integer, List<StringBuilder>> shortPathMap = initShortPathList(vertexNum, start, distance);
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
                            shortPathMap.get(j).add(minPath);
                        }
                    }
                }
            }
            if (index != -1) {
                // 加上直接连接的情况
                if (adjMatrix[start][index] <= distance[index]) {
                    shortPathMap.get(index).add(new StringBuilder(getVex(start) + "," + getVex(index)));
                }
                finds[index] = true;
                for (int j = 0; j < vertexNum; j++) {
                    if (!finds[j]) {
                        int curLen = adjMatrix[index][j];
                        if (curLen != Integer.MAX_VALUE && curLen != 0) {
                            int pathLen = min + curLen;
                            if (pathLen < distance[j]) {
                                distance[j] = pathLen;
                                shortPaths[j] = new StringBuilder(minPath).append(",").append(vertex[j]);
                                clearAndAddShortMap(shortPathMap, shortPaths[j], j);
                            } else if (pathLen == distance[j]) {
                                shortPaths[j] = new StringBuilder(minPath).append(",").append(vertex[j]);
                                shortPathMap.get(j).add(shortPaths[j]);
                            }
                        }
                    }
                }
            }
        }
        Set<Map.Entry<Integer, List<StringBuilder>>> entrySet = shortPathMap.entrySet();
        Map<String, List<StringBuilder>> pointStrPathMap = new HashMap<>();
        for (Map.Entry<Integer, List<StringBuilder>> entry : entrySet) {
            Integer key = entry.getKey();
            List<StringBuilder> value = filterRepeate(entry.getValue());
            String point = String.valueOf(getVex(key));
            pointStrPathMap.put(point, value);
        }
        dijkstraVO.setShortPathMap(pointStrPathMap);
        return dijkstraVO;
    }

    private List<StringBuilder> filterRepeate(List<StringBuilder> value) {
        Set<String> paths = new HashSet<>();
        List<StringBuilder> pathList = new ArrayList<>();
        value.forEach(p -> {
            String strPath = p.toString();
            if (!paths.contains(strPath)) {
                paths.add(strPath);
                pathList.add(p);
            }
        });
        return pathList;
    }

    private void clearAndAddShortMap(Map<Integer, List<StringBuilder>> shortPathMap, StringBuilder shortPath, int j) {
        shortPathMap.get(j).clear();
        shortPathMap.get(j).add(shortPath);
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

    private Map<Integer, List<StringBuilder>> initShortPathList(int vertexNum, int start, int[] distance) {
        Map<Integer, List<StringBuilder>> shortPathMap = new HashMap<>();
        for (int i = 0; i < vertexNum; i++) {
            List<StringBuilder> stringBuilderList = new ArrayList<>();
            shortPathMap.put(i, stringBuilderList);
        }
        return shortPathMap;
    }
}
