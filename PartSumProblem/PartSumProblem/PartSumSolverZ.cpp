//
//  PartSumSolverZ.cpp
//  PartSumProblem
//
//  Created by 岩佐 淳史 on 2013/03/08.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#include "PartSumSolverZ.h"

PartSumSolverZ::PartSumSolverZ(int target, int values[], int counts[], int length)
{
    this->target = target;
    this->values = values;
    this->counts = counts;
    this->length = length;
    
    this->result = new int[target + 1];
    this->result[0] = 0;
    for(int i = 1; i <= target; ++i) this->result[i] = -1;
}

bool PartSumSolverZ::solve()
{
    return solve(target, values, counts, length);
}

bool PartSumSolverZ::solve(int target, int values[], int counts[], int length)
{
    // dp[i + 1][j] = mi(dp[i][j]>=0) or -1(j<ai or dp[i+1][j-ai] <= 0) or dp[i + 1][j - ai] - 1
    for(int j = 1; j <= length; ++j)
    {
        for(int i = 0; i <= target; ++i)
        {
            if(this->result[i] >= 0) this->result[i] = counts[j - 1];
            else if(i < values[j - 1] || result[i - values[j - 1]] <= 0) this->result[i] = -1;
            else this->result[i] = this->result[i - values[j - 1]] - 1;
        }
    }
    return this->result[target] >= 0;
}

void PartSumSolverZ::print()
{
    for(int i = 0;  i <= target; ++i)
        std::cout << result[i] << ' ';
}

PartSumSolverZ::~PartSumSolverZ()
{
    delete[] this->result;
}