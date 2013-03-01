//
//  KnapsackInfSolver.h
//  KnapsackInfiniteProblem
//
//  Created by 岩佐 淳史 on 13/03/01.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#ifndef __KnapsackInfiniteProblem__KnapsackInfSolver__
#define __KnapsackInfiniteProblem__KnapsackInfSolver__

#include <iostream>

class KnapsackInfSolver
{
public:
    KnapsackInfSolver(int max_weight, int weights[], int values[], int length);
    int solve();
    int solve(int max_weight, int weights[], int values[], int length);
    ~KnapsackInfSolver();
private:
    int** sums;
    private int max_weight;
    private int* weights;
    private int* values;
    private int length;
};

#endif /* defined(__KnapsackInfiniteProblem__KnapsackInfSolver__) */
