package com.scd.graph;

/**
 * 图的种类
 * 有向图、
 * 有向网、
 * 无向图、
 * 无向网
 */
public enum GraphKind {
	/**
	 * 无向图 UnDirected Graph
	 */
    UDG,
	/**
	 * 有向图 Directed Graph
	 */
    DG,
	/**
	 * 无向网 UnDirected Network
	 */
    UDN,
	/**
	 * 有向网 Directed Network
	 */
    DN;
}
