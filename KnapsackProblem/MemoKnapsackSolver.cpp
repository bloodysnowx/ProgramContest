//
//  MemoKnapsackSolver.cpp
//  KnapsackProblem
//
//  Created by 岩佐 淳史 on 13/02/19.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#include "MemoKnapsackSolver.h"

#if !defined(MAX)
#define MAX(A,B)	({ __typeof__(A) __a = (A); __typeof__(B) __b = (B); __a < __b ? __b : __a; })
#endif

MemoKnapsackSolver::MemoKnapsackSolver(int max_weight, int weights[], int values[], int length) : IKnapsackSolver(max_weight, weights, values, length)
{
    sums = new int*[length + 1];
    for(int i = 0; i <= length; ++i)
    {
        sums[i] = new int[max_weight + 1];
        for(int j = 0; j <= max_weight; ++j)
            sums[i][j] = -1;
    }
    /*
    for(int j = 0; j <= max_weight; ++j)
        sums[0][j] = 0;
    */
}

int MemoKnapsackSolver::solve(int max_weight, int weights[], int values[], int length)
{
    if(length == 0) return 0;
    if(sums[length][max_weight] < 0) sums[length][max_weight] =
        MAX(solve(max_weight, weights, values, length - 1),
            (max_weight - weights[length - 1] >= 0 ? solve(max_weight - weights[length - 1], weights, values, length - 1) : 0) + values[length - 1]);
    return sums[length][max_weight];
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