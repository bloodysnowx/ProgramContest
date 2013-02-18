//
//  main.m
//  KnapsackProblem
//
//  Created by 岩佐 淳史 on 2013/02/18.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <iostream>
#import "KnapsackSolver.h"
#import "RecursiveKnapsackSolver.h"

int main(int argc, const char * argv[])
{
    @autoreleasepool {
        std::cout << "Hello, World!" << std::endl;

        int max_weight = 10;
        int weights[] = { 2, 2, 4, 6, 8 };
        int values[] = { 1, 2, 4, 5, 6 };
        int STONE_COUNT = sizeof(weights) / sizeof(weights[0]);
        IKnapsackSolver* solver = new KnapsackSolver();
        int result = solver->solve(max_weight, weights, values, STONE_COUNT);
        
        max_weight = 100;
        int weights2[] =
        {
            1,  2,  3,  4,  5,  6,  7,  8,  9, 10,
            1,  2,  3,  4,  5,  6,  7,  8,  9, 10,
            1,  2,  3,  4,  5,  6,  7,  8,  9, 10,
            1,  2,  3,  4,  5,  6,  7,  8,  9, 10,
            1,  2,  3,  4,  5,  6,  7,  8,  9, 10,
            1,  2,  3,  4,  5,  6,  7,  8,  9, 10,
            1,  2,  3,  4,  5,  6,  7,  8,  9, 10,
            1,  2,  3,  4,  5,  6,  7,  8,  9, 10,
            1,  2,  3,  4,  5,  6,  7,  8,  9, 10,
            1,  2,  3,  4,  5,  6,  7,  8,  9, 10,
        };
        int values2[] =
        {
            1,  2,  3,  4,  5,  6,  7,  8,  9, 10,
            1,  1,  1,  1,  1,  2,  2,  2,  2,  2,
            2,  2,  2,  2,  2,  3,  3,  3,  3,  3,
            3,  3,  3,  3,  3,  4,  4,  4,  4,  4,
            4,  4,  4,  4,  4,  5,  5,  5,  5,  5,
            5,  5,  5,  5,  5,  6,  6,  6,  6,  6,
            6,  6,  6,  6,  6,  7,  7,  7,  7,  7,
            7,  7,  7,  7,  7,  8,  8,  8,  8,  8,
            8,  8,  8,  8,  8,  9,  9,  9,  9,  9,
            9,  9,  9,  9,  9, 10, 10, 10, 10, 10,
        };
        STONE_COUNT = sizeof(weights2) / sizeof(weights2[0]);
        result = solver->solve(max_weight, weights2, values2, STONE_COUNT);
        
        delete solver;
        
        solver = new KnapsackSolver(max_weight, weights2, values2, STONE_COUNT);
        int calc_count = 10000;
        NSLog(@"start solve %d", calc_count);
        NSDate* date = [NSDate date];
        for(int i = 0; i < calc_count; ++i)
            result = solver->solve();
        NSTimeInterval elapsed = [[NSDate date] timeIntervalSinceDate:date];
        NSLog(@"answer = %d, elapsed = %lf", result, elapsed);
        delete solver;
        
        STONE_COUNT = 25;
        solver = new RecursiveKnapsackSolver(max_weight, weights2, values2, STONE_COUNT);
        calc_count = 1;
        NSLog(@"start solve %d", calc_count);
        date = [NSDate date];
        for(int i = 0; i < calc_count; ++i)
            result = solver->solve();
        elapsed = [[NSDate date] timeIntervalSinceDate:date];
        NSLog(@"answer = %d, elapsed = %lf", result, elapsed);
        delete solver;
    }
    return 0;
}

