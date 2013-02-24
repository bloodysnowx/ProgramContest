//
//  LCSSolver.h
//  LCSProblem
//
//  Created by 岩佐 淳史 on 13/02/25.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#ifndef __LCSProblem__LCSSolver__
#define __LCSProblem__LCSSolver__

class LCSSolver
{
public:
    LCSSolver(const char* const a, const char* const b, const size_t a_len, const size_t b_len);
    int solve();
    ~LCSSolver();
    void print();
private:
    int solve(const char* const a, const char* const b, const size_t a_len, const size_t b_len);
    int** lcs_len;
    const char* const a;
    const char* const b;
    size_t a_len;
    size_t b_len;
};


#endif /* defined(__LCSProblem__LCSSolver__) */
