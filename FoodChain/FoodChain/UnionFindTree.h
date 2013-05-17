//
//  UnionFindTree.h
//  FoodChain
//
//  Created by 岩佐 淳史 on 2013/05/17.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#ifndef __FoodChain__UnionFindTree__
#define __FoodChain__UnionFindTree__

#include <iostream>
#include <vector>
#include <algorithm>

class UnionFindTree
{
private:
    std::vector<int> data;
public:
    UnionFindTree(int size) : data(size, -1) { }
    bool unionSet(int x, int y) {
        x = root(x); y = root(y);
        if (x != y) {
            if (data[y] < data[x]) std::swap(x, y);
            data[x] += data[y]; data[y] = x;
        }
        return x != y;
    }
    bool findSet(int x, int y) {
        return root(x) == root(y);
    }
    int root(int x) {
        return data[x] < 0 ? x : data[x] = root(data[x]);
    }
    int size(int x) {
        return -data[root(x)];
    }
};

#endif /* defined(__FoodChain__UnionFindTree__) */
