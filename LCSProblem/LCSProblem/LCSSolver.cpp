//
//  LCSSolver.cpp
//  LCSProblem
//
//  Created by 岩佐 淳史 on 13/02/25.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#include "LCSSolver.h"
#include <iomanip>

LCSSolver::LCSSolver(const char* const a, const char* const b, const size_t a_len, const size_t b_len) : a(a), b(b), a_len(a_len), b_len(b_len)
{
    lcs_len = new int*[a_len + 1];
    for(int i = 0; i < a_len + 1; ++i)
    {
        lcs_len[i] = new int[b_len + 1];
        for(int j = 0; j < b_len + 1; ++j)
            lcs_len[i][j] = i * j == 0 ? 0 : -1;
    }
}

int LCSSolver::solve()
{
    return this->solve(a, b, a_len, b_len);
}

int LCSSolver::solve(const char* const a, const char* const b, const size_t a_len, const size_t b_len)
{
    for(int i = 1; i < a_len + 1; ++i)
    {
        for(int j = 1; j < b_len + 1; ++j)
        {
            lcs_len[i][j] = (a[i - 1] == b[j - 1] && lcs_len[i][j-1] == lcs_len[i-1][j]) ? lcs_len[i][j - 1] + 1 : MAX(lcs_len[i][j-1], lcs_len[i-1][j]);
        }
    }
    return lcs_len[a_len][b_len];
}

void LCSSolver::print()
{
    for(int i = 0; i < a_len + 1; ++i)
    {
        for(int j = 0; j < b_len + 1; ++j)
            std::cout << std::setw(2) << lcs_len[i][j] << ' ';
        std::cout << std::endl;
    }
    /*
    for(int i = 1; i < a_len + 1; ++i)
    {
        if(lcs_len[i-1][b_len] < lcs_len[i][b_len])
            std::cout << a[i-1] << '@' << i - 1 << ' ';
    }
    std::cout << std::endl;

    for(int j = 1; j < b_len + 1; ++j)
    {
        if(lcs_len[a_len][j-1] < lcs_len[a_len][j])
            std::cout << b[j-1] << '@' << j - 1 << ' ';
    }
    std::cout << std::endl;
    */
}

LCSSolver::~LCSSolver()
{
    for(int i = 0; i < a_len + 1; ++i)
        delete [] lcs_len[i];
    delete [] lcs_len;
}