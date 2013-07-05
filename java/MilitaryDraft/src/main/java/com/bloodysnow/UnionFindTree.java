package com.bloodysnow;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Atsushi
 * Date: 2013/07/05
 * Time: 11:05
 * To change this template use File | Settings | File Templates.
 */
public class UnionFindTree {
    private int[] data;
    public UnionFindTree(int size) {
        data = new int[size];
        for(int i = 0; i < size; ++i) data[i] = -1;
    }
    public boolean unionSet(int x, int y) {
        x = root(x);
        y = root(y);
        if(x != y) {
            if (data[y] < data[x]) {
                int tmp = data[x];
                data[x] = data[y];
                data[y] = tmp;
            }
            data[x] += data[y];
            data[y] = x;
        }
        return x != y;
    }
    public boolean findSet(int x, int y) { return root(x) == root(y); }
    public int root(int x) {
        if(data[x] < 0) return x;
        else return data[x] = root(data[x]);
    }
    public int size(int x) { return -data[root(x)]; }
}
