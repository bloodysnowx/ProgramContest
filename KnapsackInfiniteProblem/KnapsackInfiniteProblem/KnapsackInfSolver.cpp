//
//  KnapsackInfSolver.cpp
//  KnapsackInfiniteProblem
//
//  Created by 岩佐 淳史 on 13/03/01.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#include "KnapsackInfSolver.h"

KnapsackInfSolver::KnapsackInfSolver(int max_weight, int weights[], int values[], int length)
{
    this->max_weight = max_weight;
    this->weights = weights;
    this->values = values;
    this->length = length;

    // 0 -> @0, 1 -> @1, ... , length-1 -> @length-1, length -> MAX
    sums = new int*[length + 1];
    for(int i = 0; i <= length; ++i)
        sums[i] = new int[max_weight + 1];
    for(int j = 0; j <= max_weight; ++j)
        sums[0][j] = 0;
}

int KnapsackInfSolver::solve()
{
}

int KnapsackInfSolver::solve(int max_weight, int weights[], int values[], int length)
{
}

KnapsackInfSolver::~KnapsackInfSolver()
{
    for(int i = 0; i < length + 1; ++i)
        delete[] sums[i];
    delete[] sums;
}
