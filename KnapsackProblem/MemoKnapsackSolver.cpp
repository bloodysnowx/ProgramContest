//
//  MemoKnapsackSolver.cpp
//  KnapsackProblem
//
//  Created by 岩佐 淳史 on 13/02/19.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#include "MemoKnapsackSolver.h"

MemoKnapsackSolver::MemoKnapsackSolver(int max_weight, int weights[], int values[], int length) : IKnapsackSolver(max_weight, weights, values, length)
{
    sums = new int*[length + 1];
    for(int i = 0; i <= length; ++i)
        sums[i] = new int[max_weight + 1];
    for(int j = 0; j <= max_weight; ++j)
        sums[0][j] = 0;
}

int MemoKnapsackSolver::solve(int max_weight, int weights[], int values[], int length)
{
    if(length == 0) return 0;
    return 0;
}

int MemoKnapsackSolver::solve()
{
    return solve(max_weight, weights, values, length);
}

MemoKnapsackSolver::~MemoKnapsackSolver()
{
    for(int i = 0; i < length + 1; ++i)
        delete[] sums[i];
    delete[] sums;
}