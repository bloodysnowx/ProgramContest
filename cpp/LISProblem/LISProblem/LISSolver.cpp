//
//  LISSolver.cpp
//  LISProblem
//
//  Created by 岩佐 淳史 on 2013/04/04.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#include "LISSolver.h"
#include <algorithm>
#include "LCSSolver.cpp"

LISSolver::LISSolver(const int* const a, const size_t a_len) : a(a), a_len(a_len)
{
    b = new int[a_len];
    for(int i = 0; i < a_len; ++i)
        b[i] = a[i];

    std::sort(b, b + a_len);

    lcsSolver = new LCSSolver<int>(a, b, a_len, a_len);
}

LISSolver::~LISSolver()
{
    delete lcsSolver;
    delete [] b;
}

int LISSolver::solve()
{
    return lcsSolver->solve();
}

void LISSolver::print()
{
    
}