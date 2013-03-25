//
//  RecursiveKnapsackSolver.cpp
//  KnapsackProblem
//
//  Created by 岩佐 淳史 on 13/02/19.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#include "RecursiveKnapsackSolver.h"

#if !defined(MAX)
#define MAX(A,B)	({ __typeof__(A) __a = (A); __typeof__(B) __b = (B); __a < __b ? __b : __a; })
#endif

RecursiveKnapsackSolver::RecursiveKnapsackSolver(int max_weight, int weights[], int values[], int length) : IKnapsackSolver(max_weight, weights, values, length)
{
    
}

int RecursiveKnapsackSolver::solve(int max_weight, int weights[], int values[], int length)
{
    if(length == 0) return 0;
    int result = solve(max_weight, weights, values, length - 1);
    if(max_weight - weights[length - 1] > 0) result = MAX(result, solve(max_weight - weights[length - 1], weights, values, length - 1) + values[length - 1]);
    return result;
}

int RecursiveKnapsackSolver::solve()
{
    return solve(max_weight, weights, values, length);
}

RecursiveKnapsackSolver::~RecursiveKnapsackSolver()
{
    std::cout << "~RecursiveKnapsackSolver()" << std::endl;
}