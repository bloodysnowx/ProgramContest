//
//  PartSumSolverZ.h
//  PartSumProblem
//
//  Created by 岩佐 淳史 on 2013/03/08.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#ifndef __PartSumProblem__PartSumSolverZ__
#define __PartSumProblem__PartSumSolverZ__

#include <iostream>

class PartSumSolverZZ
{
public:
    PartSumSolverZZ(int target, int values[], int counts[], int length);
    bool solve();
    bool solve(int target, int values[], int counts[], int length);
    void print();
    ~PartSumSolverZZ();
private:
    int* result;
    int target;
    int* values;
    int* counts;
    int length;
};

#endif /* defined(__PartSumProblem__PartSumSolverZ__) */
