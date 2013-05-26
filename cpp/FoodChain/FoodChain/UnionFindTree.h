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
    UnionFindTree(int size);
    bool unionSet(int x, int y);
    bool findSet(int x, int y);
    int root(int x);
    int size(int x);
};

#endif /* defined(__FoodChain__UnionFindTree__) */
