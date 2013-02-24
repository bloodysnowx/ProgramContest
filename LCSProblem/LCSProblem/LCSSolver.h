//
//  LCSSolver.h
//  LCSProblem
//
//  Created by 岩佐 淳史 on 13/02/25.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#ifndef __LCSProblem__LCSSolver__
#define __LCSProblem__LCSSolver__

#include <iostream>

class LCSSolver
{
public:
    LCSSolver(char* a, char* b, int a_len, int b_len);
    int solve();
    ~LCSSolver();
private:
    int solve(char* a, char* b, int a_len, int b_len);
    int** lcs_len;
    char* a;
    char* b;
    int a_len;
    int b_len;
};


#endif /* defined(__LCSProblem__LCSSolver__) */
