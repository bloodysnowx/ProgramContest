//
//  KnapsackInfiniteSolverZ.cpp
//  KnapsackInfiniteProblem
//
//  Created by 岩佐 淳史 on 2013/03/04.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#include "KnapsackInfiniteSolverZ.h"
#include <iomanip>
#include <algorithm>
#include <functional>

class Sorter {
public:
    bool operator()(const stone& riLeft, const stone& riRight) const {
        if (riLeft.value * riRight.weight == riRight.value * riLeft.weight) return riLeft.weight < riRight.weight;
        return riLeft.value * riRight.weight > riRight.value * riLeft.weight;
    }
};

KnapsackInfSolverZ::KnapsackInfSolverZ(int max_weight, int weights[], int values[], int length)
{
    this->max_weight = max_weight;
    this->weights = weights;
    this->values = values;
    this->length = length;
    
    sums = new int[max_weight + 1];
    sums[0]= 0;
    for(int i = 1; i <= max_weight; ++i)
        sums[i] = -1;

    stones = new stone[length];
    for(int i = 0; i < length; ++i)
        stones[i] = stone{weights[i], values[i], (float)values[i] / weights[i]};
    std::sort(stones, stones + length, Sorter());
    
    for(int i = 1; i * stones[0].weight <= max_weight; ++i)
    {
        sums[i * stones[0].weight] = stones[0].value * i;
        if(length >= 2 && i * stones[0].weight + stones[1].weight <= max_weight)
            sums[i * stones[0].weight + stones[1].weight] = sums[i * stones[0].weight] + stones[1].value;
    }
}

int KnapsackInfSolverZ::solve()
{
    return this->solve(max_weight, weights, values, length);
}

int KnapsackInfSolverZ::solve(int max_weight, int weights[], int values[], int length)
{
    if(sums[max_weight] >= 0) return sums[max_weight];
    
    for(int i = 1; i <= max_weight; ++i)
    {
        if(sums[i] >= 0) continue;
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

void KnapsackInfSolverZ::print()
{
    for(int i = 0; i <= max_weight; ++i)
        std::cout << std::setw(2) << sums[i] << ' ';
    
    std::cout << std::endl;
}

KnapsackInfSolverZ::~KnapsackInfSolverZ()
{
    delete[] sums;
    delete[] stones;
}
