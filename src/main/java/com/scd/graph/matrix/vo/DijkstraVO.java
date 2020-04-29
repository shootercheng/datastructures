package com.scd.graph.matrix.vo;

/**
 * @author James
 */
public class DijkstraVO {
    private StringBuilder[] shortPaths;

    private int[] distance;

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
}
