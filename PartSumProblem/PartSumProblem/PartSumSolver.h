//
//  PartSumSolver.h
//  PartSumProblem
//
//  Created by 岩佐 淳史 on 2013/03/08.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#ifndef __PartSumProblem__PartSumSolver__
#define __PartSumProblem__PartSumSolver__

#include <iostream>

class PartSumSolver
{
public:
    PartSumSolver(int target, int values[], int counts[], int length);
    bool solve();
    bool solve(int target, int values[], int counts[], int length);
    void print();
    ~PartSumSolver();
private:
    int** result;
    int target;
    int* values;
    int* counts;
    int length;
};
#endif /* defined(__PartSumProblem__PartSumSolver__) */
