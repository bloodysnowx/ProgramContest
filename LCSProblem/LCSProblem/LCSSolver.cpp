//
//  LCSSolver.cpp
//  LCSProblem
//
//  Created by 岩佐 淳史 on 13/02/25.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#include "LCSSolver.h"

LCSSolver::LCSSolver(char* a, char* b, int a_len, int b_len)
{
    this->a = a;
    this->b = b;
    this->a_len = a_len;
    this->b_len = b_len;
    lcs_len = new int*[a_len + 1];
    for(int i = 0; i < a_len + 1; ++i)
    {
        lcs_len[i] = new int[b_len + 1];
        for(int j = 0; j < b_len + 1; ++j)
            lcs_len[i][j] = -1;
    }

}

int LCSSolver::solve()
{
    return this->solve(a, b, a_len, b_len);
}

int LCSSolver::solve(char* a, char* b, int a_len, int b_len)
{
    if(a_len == 0 || b_len == 0) return 0;
    return 0;
}

LCSSolver::~LCSSolver()
{
    for(int i = 0; i < a_len + 1; ++i)
        delete [] lcs_len[i];
    delete [] lcs_len;
}