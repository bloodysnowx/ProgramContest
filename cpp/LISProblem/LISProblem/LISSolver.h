//
//  LISSolver.h
//  LISProblem
//
//  Created by 岩佐 淳史 on 2013/04/04.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#ifndef __LISProblem__LISSolver__
#define __LISProblem__LISSolver__

#include <iostream>
#include "LCSSolver.h"

class LISSolver
{
public:
    LISSolver(const int* const a, const size_t a_len);
    int solve();
    ~LISSolver();
    void print();
private:
    // int solve(const char* const a, const size_t a_len);
    const int* const a;
    int* b;
    const size_t a_len;
    LCSSolver<int>* lcsSolver;
};


#endif /* defined(__LISProblem__LISSolver__) */
