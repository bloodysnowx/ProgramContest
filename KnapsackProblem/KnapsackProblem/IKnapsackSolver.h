//
//  IKnapsackSolver.h
//  KnapsackProblem
//
//  Created by 岩佐 淳史 on 13/02/19.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#ifndef __KnapsackProblem__IKnapsackSolver__
#define __KnapsackProblem__IKnapsackSolver__

#include <iostream>

class IKnapsackSolver
{
public:
    IKnapsackSolver() : IKnapsackSolver(-1, nullptr, nullptr, -1) { };
    IKnapsackSolver(int max_weight, int weights[], int values[], int length)
    {
        this->max_weight = max_weight;
        this->weights = weights;
        this->values = values;
        this->length = length;
    }
    virtual int solve() = 0;
    virtual int solve(int max_weight, int weights[], int values[], int length) = 0;
    virtual ~IKnapsackSolver() { std::cout << "~IKnapsackSolver()" << std::endl; };
protected:
    // int** sums;
    int* weights;
    int* values;
    int length;
    int max_weight;
};

#endif /* defined(__KnapsackProblem__IKnapsackSolver__) */
