//
//  IPartSumSolver.h
//  PartSumProblem
//
//  Created by 岩佐 淳史 on 2013/03/14.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#ifndef __PartSumProblem__IPartSumSolver__
#define __PartSumProblem__IPartSumSolver__

#include <iostream>

class IPartSumSolver
{
public:
    IPartSumSolver(int target, int values[], int counts[], int length);
    virtual bool solve() = 0;
    virtual bool solve(int target, int values[], int counts[], int length) = 0;
    virtual void print() = 0;
    virtual ~IPartSumSolver() = 0;
protected:
    // int** result;
    int target;
    int* values;
    int* counts;
    int length;
};
#endif /* defined(__PartSumProblem__IPartSumSolver__) */
