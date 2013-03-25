//
//  KnapsackInfSolver.cpp
//  KnapsackInfiniteProblem
//
//  Created by 岩佐 淳史 on 13/03/01.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#include "KnapsackInfSolver.h"
#include <iomanip>

KnapsackInfSolver::KnapsackInfSolver(int max_weight, int weights[], int values[], int length)
{
    this->max_weight = max_weight;
    this->weights = weights;
    this->values = values;
    this->length = length;

    sums = new int[max_weight + 1];
    sums[0] = 0;
}

int KnapsackInfSolver::solve()
{
    return this->solve(max_weight, weights, values, length);
}

int KnapsackInfSolver::solve(int max_weight, int weights[], int values[], int length)
{
    for(int i = 1; i <= max_weight; ++i)
    {
        int max = 0;
        for(int j = 0; j < length; ++j)
        {
            if(weights[j] > i) continue;
            else max = MAX(max, sums[i - weights[j]] + values[j]);
        }
        sums[i] = max;
    }
    
    return sums[max_weight];
}

void KnapsackInfSolver::print()
{
    for(int i = 0; i <= max_weight; ++i)
        std::cout << std::setw(2) << sums[i] << ' ';

    std::cout << std::endl;
}

KnapsackInfSolver::~KnapsackInfSolver()
{
    delete[] sums;
}
