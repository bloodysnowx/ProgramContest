//
//  KnapsackSolver.m
//  KnapsackProblem
//
//  Created by 岩佐 淳史 on 13/02/18.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#import "KnapsackSolver.h"
#import <iostream>

int KnapsackSolver::solve(int max_weight, int weights[], int values[], int length)
{
    // length, max_weight
    int** sums = new int*[length + 1];
    for(int i = 0; i <= length; ++i) sums[i] = new int[max_weight + 1];
    for(int j = 0; j <= max_weight; ++j) sums[0][j] = 0;
    
    for(int i = 1; i <= length; ++i)
    {
        for(int j = 0; j < weights[i - 1]; ++j) sums[i][j] = sums[i - 1][j];
        for(int j = weights[i - 1]; j <= max_weight; ++j) sums[i][j] = MAX(sums[i - 1][j], sums[i - 1][j - weights[i - 1]] + values[i - 1]);
    }
    int max_value = sums[length][max_weight];

    for(int i = 0; i < length + 1; ++i) delete[] sums[i];
    delete[] sums;
    
    return max_value;
}

KnapsackSolver::KnapsackSolver()
{
    sums = nullptr;
    this->max_weight = -1;
    this->weights = nullptr;
    this->values = nullptr;
    this->length = -1;
}

KnapsackSolver::KnapsackSolver(int max_weight, int weights[], int values[], int length) : IKnapsackSolver(max_weight, weights, values, length)
{
    sums = new int*[length + 1];
    for(int i = 0; i <= length; ++i) sums[i] = new int[max_weight + 1];
    for(int j = 0; j <= max_weight; ++j) sums[0][j] = 0;
}
int KnapsackSolver::solve()
{
    for(int i = 1; i <= length; ++i)
    {
        for(int j = 0; j < weights[i - 1]; ++j) sums[i][j] = sums[i - 1][j];
        for(int j = weights[i - 1]; j <= max_weight; ++j) sums[i][j] = MAX(sums[i - 1][j], sums[i - 1][j - weights[i - 1]] + values[i - 1]);
    }
    return sums[length][max_weight];
}
KnapsackSolver::~KnapsackSolver()
{
    for(int i = 0; i < length + 1; ++i) delete[] sums[i];
    delete[] sums;
    NSLog(@"~KnapsackSolver()");
}