//
//  LCSSolver.h
//  LCSProblem
//
//  Created by 岩佐 淳史 on 13/02/25.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#ifndef __LCSProblem__LCSSolver__
#define __LCSProblem__LCSSolver__

template <typename T> class LCSSolver
{
public:
    LCSSolver(const T* const a, const T* const b, const size_t a_len, const size_t b_len);
    int solve();
    ~LCSSolver();
    void print();
private:
    int solve(const T* const a, const T* const b, const size_t a_len, const size_t b_len);
    int** lcs_len;
    const T* const a;
    const T* const b;
    size_t a_len;
    size_t b_len;
};


#endif /* defined(__LCSProblem__LCSSolver__) */
