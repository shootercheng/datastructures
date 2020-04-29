package com.scd.graph.matrix;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author James
 */
public class Traverse {

    public static void bfsTraverse(BaseGraph baseGraph) {
        // 记录访问过的节点
        boolean[] visited = new boolean[baseGraph.getVexNum()];
        for (int i = 0; i < baseGraph.getVexNum(); i++) {
            if (!visited[i]) {
                bfs(baseGraph, i, visited);
            }
        }
    }

    private static void bfs(BaseGraph baseGraph, int i, boolean[] visited) {
        visited[i] = true;
        System.out.println(baseGraph.getVex(i) + " ");
        int verNum = baseGraph.getVexNum();
        // 队列存储结点索引
        Queue<Integer> indexQueue = new ArrayDeque<>(verNum);
        indexQueue.offer(i);
        while (!indexQueue.isEmpty()) {
            int j = indexQueue.poll();
            for (int w = baseGraph.firstAdjVex(j); w > 0; w = baseGraph.nextAdjVex(j, w)) {
                if (!visited[w]) {
                    visited[w] = true;
                    System.out.println(baseGraph.getVex(w) + " ");
                    indexQueue.offer(w);
                }
            }
        }
    }

    public static void dfsTraverse(BaseGraph baseGraph) {
        // 记录访问过的节点
        boolean[] visited = new boolean[baseGraph.getVexNum()];
        for (int i = 0; i < baseGraph.getVexNum(); i++) {
            if (!visited[i]) {
                dfs(baseGraph, i, visited);
            }
        }
    }

    private static void dfs(BaseGraph baseGraph, int i, boolean[] visited) {
        // 当前节点设置为已访问
        visited[i] = true;
        System.out.println(baseGraph.getVex(i) + " ");
        for (int w = baseGraph.firstAdjVex(i); w > 0; w = baseGraph.nextAdjVex(i, w)) {
            if (!visited[w]) {
                dfs(baseGraph, w, visited);
            }
        }
    }
}
