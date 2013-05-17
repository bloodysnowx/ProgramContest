//
//  FoodChainSolver.cpp
//  FoodChain
//
//  Created by 岩佐 淳史 on 2013/05/17.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#include "FoodChainSolver.h"

FoodChainSolver::FoodChainSolver(int number, int* type, int* x, int* y, int length) : number(number), type(type), x(x), y(y), length(length)
{
    tree = new UnionFindTree(length);
}

FoodChainSolver::~FoodChainSolver()
{
    delete tree;
}