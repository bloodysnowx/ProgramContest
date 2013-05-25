//
//  KnapsackInfiniteSolverZ.h
//  KnapsackInfiniteProblem
//
//  Created by 岩佐 淳史 on 2013/03/04.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#ifndef __KnapsackInfiniteProblem__KnapsackInfiniteSolverZ__
#define __KnapsackInfiniteProblem__KnapsackInfiniteSolverZ__

#include <iostream>

typedef struct {
    int weight;
    int value;
    float v_per_w;
} stone;

class KnapsackInfSolverZ
{
public:
    KnapsackInfSolverZ(int max_weight, int weights[], int values[], int length);
    int solve();
    int solve(int max_weight, int weights[], int values[], int length);
    void print();
    ~KnapsackInfSolverZ();
private:
    int* sums;
    int max_weight;
    int* weights;
    int* values;
    int length;
    stone* stones;
};

#endif /* defined(__KnapsackInfiniteProblem__KnapsackInfiniteSolverZ__) */
