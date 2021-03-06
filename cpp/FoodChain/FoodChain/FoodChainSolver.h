//
//  FoodChainSolver.h
//  FoodChain
//
//  Created by 岩佐 淳史 on 2013/05/17.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#ifndef __FoodChain__FoodChainSolver__
#define __FoodChain__FoodChainSolver__

#include <iostream>
#include "UnionFindTree.h"
#include "FoodChainInfo.h"

class FoodChainSolver
{
private:
    UnionFindTree* tree;
    int animalCount;
    int* type;
    int* x;
    int* y;
    int length;
    FoodChainInfo** info;
public:
    FoodChainSolver(int animalCount, int* type, int* x, int* y, int length);
    ~FoodChainSolver();
    int solve();
};

#endif /* defined(__FoodChain__FoodChainSolver__) */
