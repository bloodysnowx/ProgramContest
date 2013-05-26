//
//  UnionFindTree.cpp
//  FoodChain
//
//  Created by 岩佐 淳史 on 2013/05/17.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#include "UnionFindTree.h"

UnionFindTree::UnionFindTree(int size) : data(size, -1)
{
}

bool UnionFindTree::unionSet(int x, int y) {
    x = root(x); y = root(y);
    if (x != y) {
        if (data[y] < data[x]) std::swap(x, y);
        data[x] += data[y]; data[y] = x;
    }
    return x != y;
}

bool UnionFindTree::findSet(int x, int y) {
    return root(x) == root(y);
}

int UnionFindTree::root(int x) {
    return data[x] < 0 ? x : data[x] = root(data[x]);
}

int UnionFindTree::size(int x) {
    return -data[root(x)];
}