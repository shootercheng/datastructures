package com.scd.graph.matrix.vo;

import java.util.List;
import java.util.Map;

/**
 * @author James
 */
public class DijkstraVO {
    private StringBuilder[] shortPaths;

    private int[] distance;

    private Map<String, List<StringBuilder>> shortPathMap;

    public StringBuilder[] getShortPaths() {
        return shortPaths;
    }

    public void setShortPaths(StringBuilder[] shortPaths) {
        this.shortPaths = shortPaths;
    }

    public int[] getDistance() {
        return distance;
    }

    public void setDistance(int[] distance) {
        this.distance = distance;
    }

    public Map<String, List<StringBuilder>> getShortPathMap() {
        return shortPathMap;
    }

    public void setShortPathMap(Map<String, List<StringBuilder>> shortPathMap) {
        this.shortPathMap = shortPathMap;
    }
}
