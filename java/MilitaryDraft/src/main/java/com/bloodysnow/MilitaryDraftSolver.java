package com.bloodysnow;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: Atsushi
 * Date: 2013/07/05
 * Time: 10:33
 * To change this template use File | Settings | File Templates.
 */
public class MilitaryDraftSolver {
    private UnionFindTree tree;
    private Edge[] es;
    private int manCount;
    private int womanCount;
    public MilitaryDraftSolver(int[][] edges, int manCount, int womanCount) {
        this.manCount = manCount;
        this.womanCount = womanCount;
        es = new Edge[edges.length];
        for(int i = 0; i < es.length; ++i) {
            es[i] = new Edge(edges[i][0], edges[i][1] + manCount, -edges[i][2]);
        }
        java.util.Arrays.sort(es, new Comparator<Edge>() {
            @Override
            public int compare(Edge edge, Edge edge2) {
                return edge.cost - edge2.cost;
            }
        });
        tree = new UnionFindTree(manCount + womanCount + 1);
    }
    public int solve()
    {
        return this.kruskal() + (manCount + womanCount) * 10000;
    }

    private int kruskal() {
        int res = 0;
        for (Edge edge : es) {
            if(tree.findSet(edge.u, edge.v) == false) {
                tree.unionSet(edge.u, edge.v);
                res += edge.cost;
            }
        }
        return res;
    }
}
