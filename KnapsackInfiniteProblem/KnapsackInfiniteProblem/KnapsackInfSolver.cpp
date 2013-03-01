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

    // i -> weight, j -> item
    sums = new int*[max_weight + 1];
    for(int i = 0; i <= max_weight; ++i)
        // 0 -> @0, 1 -> @1, ... , length-1 -> @length-1, length -> MAX
        sums[i] = new int[length + 1];
    for(int j = 0; j <= length; ++j)
        sums[0][j] = 0;
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
            if(weights[j] > i) sums[i][j] = 0;
            else sums[i][j] = sums[i - weights[j]][length] + values[j];
            max = MAX(max, sums[i][j]);
        }
        sums[i][length] = max;
    }
    
    return sums[max_weight][length];
}

void KnapsackInfSolver::print()
{
    for(int i = 0; i <= max_weight; ++i)
    {
        for(int j = 0; j <= length; ++j)
        {
            std::cout << std::setw(2) << sums[i][j] << ' ';
        }
        std::cout << std::endl;
    }
}

KnapsackInfSolver::~KnapsackInfSolver()
{
    for(int i = 0; i < max_weight + 1; ++i)
        delete[] sums[i];
    delete[] sums;
}
