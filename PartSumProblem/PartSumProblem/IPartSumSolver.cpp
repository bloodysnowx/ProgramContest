//
//  IPartSumSolver.cpp
//  PartSumProblem
//
//  Created by 岩佐 淳史 on 2013/03/14.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#include "IPartSumSolver.h"

IPartSumSolver::IPartSumSolver(int target, int values[], int counts[], int length)
{
    this->target = target;
    this->values = values;
    this->counts = counts;
    this->length = length;
}

IPartSumSolver::~IPartSumSolver()
{
    
}