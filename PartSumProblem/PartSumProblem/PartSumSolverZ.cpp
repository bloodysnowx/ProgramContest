//
//  PartSumSolverZ.cpp
//  PartSumProblem
//
//  Created by 岩佐 淳史 on 2013/03/14.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#include "PartSumSolverZ.h"

PartSumSolverZ::PartSumSolverZ(int target, int values[], int counts[], int length) : IPartSumSolver(target, values, counts, length)
{
    this->result = new int*[length + 1];
    for(int i = 0; i <= length; ++i)
    {
        this->result[i] = new int[target + 1];
        this->result[i][0] = 0;
        for(int j = 1; j <= target; ++j) this->result[i][j] = -1;
    }
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
            if(this->result[j-1][i] >= 0) this->result[j][i] = counts[j - 1];
            else if(i < values[j - 1] || result[j-1][i - values[j - 1]] <= 0) this->result[j][i] = -1;
            else this->result[j][i] = this->result[j][i - values[j - 1]] - 1;
        }
    }
    return this->result[length][target] >= 0;
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