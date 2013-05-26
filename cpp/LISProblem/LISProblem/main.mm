//
//  main.m
//  LISProblem
//
//  Created by 岩佐 淳史 on 2013/03/29.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "LISSolver.h"
#import "LISSolverZ.h"

void test(const int* a, size_t a_len)
{
    // LISSolver* solver = new LISSolver(a, a_len);
    LISSolverZ* solver = new LISSolverZ(a, a_len);
    int answer = solver->solve();
    solver->print();
    NSLog(@"%d", answer);
    delete solver;
}

int main(int argc, const char * argv[])
{

    @autoreleasepool {
        const int a[] = {4, 3, 2, 1, 2, 3, 4};
        test(a, 7);
    }
    return 0;
}

