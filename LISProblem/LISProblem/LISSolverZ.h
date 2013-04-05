//
//  LISSolverZ.h
//  LISProblem
//
//  Created by 岩佐 淳史 on 2013/04/05.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#ifndef __LISProblem__LISSolverZ__
#define __LISProblem__LISSolverZ__

#include <iostream>

class LISSolverZ
{
public:
    LISSolverZ(const int* const a, const size_t a_len);
    int solve();
    ~LISSolverZ();
    void print();
private:
    const int* const a;
    const size_t a_len;
    int* lis_len;
};

#endif /* defined(__LISProblem__LISSolverZ__) */
