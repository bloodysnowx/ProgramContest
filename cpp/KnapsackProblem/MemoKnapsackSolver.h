//
//  MemoKnapsackSolver.h
//  KnapsackProblem
//
//  Created by 岩佐 淳史 on 13/02/19.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#ifndef __KnapsackProblem__MemoKnapsackSolver__
#define __KnapsackProblem__MemoKnapsackSolver__

#include <iostream>

#import "IKnapsackSolver.h"

class MemoKnapsackSolver : public IKnapsackSolver
{
public:
    MemoKnapsackSolver(int max_weight, int weights[], int values[], int length);
    int solve();
    ~MemoKnapsackSolver();
private:
    int solve(int max_weight, int weights[], int values[], int length);
    int** sums;
};

#endif /* defined(__KnapsackProblem__MemoKnapsackSolver__) */
