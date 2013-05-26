//
//  LISSolverZ.cpp
//  LISProblem
//
//  Created by 岩佐 淳史 on 2013/04/05.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#include "LISSolverZ.h"

LISSolverZ::LISSolverZ(const int* const a, const size_t a_len) : a(a), a_len(a_len)
{
    lis_len = new int[a_len];
}

int LISSolverZ::solve()
{
    for(int i = 0; i < a_len; ++i)
    {
        lis_len[i] = 1;
        for(int j = 0; j < i; ++j)
            if(a[i] > a[j]) lis_len[i] = MAX(lis_len[i], lis_len[j] + 1);
    }
    
    return lis_len[a_len - 1];
}

LISSolverZ::~LISSolverZ()
{
    delete [] lis_len;
}

void LISSolverZ::print()
{
    
}