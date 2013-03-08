//
//  PartSumSolver.cpp
//  PartSumProblem
//
//  Created by 岩佐 淳史 on 2013/03/08.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#include "PartSumSolver.h"

PartSumSolver::PartSumSolver(int target, int values[], int counts[], int length)
{
    this->target = target;
    this->values = values;
    this->counts = counts;
    this->length = length;
    
    // i : targetWeight, j : number
    this->result = new int*[target + 1];
    for(int i = 0; i <= target; ++i)
    {
        this->result[i] = new int[length + 1];
        this->result[i][0] = 0;
        for(int j = 1; j <= length; ++j)
            this->result[i][j] = -1;
    }
    for(int j = 0; j <= length; ++j)
        this->result[0][j] = 1;
}

bool PartSumSolver::solve()
{
    return solve(target, values, counts, length);
}

bool PartSumSolver::solve(int target, int values[], int counts[], int length)
{
    for(int j = 1; j <= length; ++j)
    {
        for(int i = 0; i <= target; ++i)
        {
            if(this->result[i][j - 1] > 0)
            {
                for(int k = 0; k <= counts[j - 1] && i + values[j - 1] * k <= target; ++k)
                {
                    this->result[i + values[j - 1] * k][j] = 1;
                }
            }
        }
    }
    return this->result[target][length] == 1;
}

void PartSumSolver::print()
{
     for(int i = 0;  i <= target; ++i)
     {
         std::cout << i << " : ";
         for(int j = 0; j <= length; ++j)
             std::cout << result[i][j] << ' ';
         std::cout << std::endl;
     }
}

PartSumSolver::~PartSumSolver()
{
    for(int i = 0; i <= target; ++i)
    {
        delete[] this->result[i];
    }
    delete[] this->result;
}