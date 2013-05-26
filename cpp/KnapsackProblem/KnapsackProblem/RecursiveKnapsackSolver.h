//
//  RecursiveKnapsackSolver.h
//  KnapsackProblem
//
//  Created by 岩佐 淳史 on 13/02/19.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#ifndef __KnapsackProblem__RecursiveKnapsackSolver__
#define __KnapsackProblem__RecursiveKnapsackSolver__

#include <iostream>
#import "IKnapsackSolver.h"

class RecursiveKnapsackSolver : public IKnapsackSolver
{
public:
    RecursiveKnapsackSolver(int max_weight, int weights[], int values[], int length);
    int solve();
    ~RecursiveKnapsackSolver();
private:
    int solve(int max_weight, int weights[], int values[], int length);
};

#endif /* defined(__KnapsackProblem__RecursiveKnapsackSolver__) */
