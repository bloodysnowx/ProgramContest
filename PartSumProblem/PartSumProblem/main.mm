//
//  main.m
//  PartSumProblem
//
//  Created by 岩佐 淳史 on 2013/03/08.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "PartSumSolver.h"

int main(int argc, const char * argv[])
{
    @autoreleasepool {
        
        // insert code here...
        NSLog(@"Hello, World!");
        int target = 17;
        int values[] = { 3, 5, 8 };
        int counts[] = { 3, 2, 2 };
        int length = sizeof(values) / sizeof(values[0]);
        PartSumSolver* solver = new PartSumSolver(target, values, counts, length);
        // solver->print();
        bool result = solver->solve();
        solver->print();
        NSLog(@"answer = %@", result ? @"true" : @"false");
        delete solver;
        
        target = 1000;
        int values2[] = { 3, 5, 8, 9, 10, 15, 18, 23, 29, 43 };
        int counts2[] = { 3, 2, 2, 5, 10, 18, 23, 40, 90, 13 };
        length = sizeof(values2) / sizeof(values2[0]);
        solver = new PartSumSolver(target, values2, counts2, length);
        result = solver->solve();
        solver->print();
        NSLog(@"answer = %@", result ? @"true" : @"false");
        delete solver;
    }
    return 0;
}

