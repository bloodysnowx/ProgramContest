//
//  main.m
//  KnapsackInfiniteProblem
//
//  Created by 岩佐 淳史 on 13/03/01.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "KnapsackInfSolver.h"
#import "KnapsackInfiniteSolverZ.h"
#import <iostream>

int main(int argc, const char * argv[])
{
    @autoreleasepool {
        int max_weight = 10;
        int weights[] = { 2, 2, 4, 6, 8 };
        int values[] = { 1, 2, 4, 5, 6 };
        int STONE_COUNT = sizeof(weights) / sizeof(weights[0]);
        
        KnapsackInfSolver* solver = new KnapsackInfSolver(max_weight, weights, values, STONE_COUNT);
        int result = solver->solve();
        // solver->print();
        delete solver;
        
        KnapsackInfSolverZ* solverZ = new KnapsackInfSolverZ(max_weight, weights, values, STONE_COUNT);
        result = solverZ->solve();
        // solverZ->print();
        delete solverZ;
        
        max_weight = 100;
        int weights2[] =
        {
            1, 12,  3,  4,  5,  6,  7,  8,  9, 10,
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
        
        solver = new KnapsackInfSolver(max_weight, weights2, values2, STONE_COUNT);
        result = solver->solve();
        // solver->print();
        delete solver;
        
        solverZ = new KnapsackInfSolverZ(max_weight, weights2, values2, STONE_COUNT);
        result = solverZ->solve();
        // solverZ->print();
        delete solverZ;
        
        max_weight = 10000;
        int weights3[] =
        {
            2,  3,  4,  5, 56,  7,  8,  9, 10, 11,
           12, 13, 14, 15, 16, 17, 18, 19, 20, 21,
           22, 23, 24, 25, 26, 27, 28, 29, 30, 31,
           32, 33, 34, 35, 36, 37, 38, 39, 40, 41,
           42, 43, 44, 45, 46, 47, 48, 49, 50, 51,
           52, 53, 54, 55, 56, 57, 58, 59, 60, 61,
           62, 63, 64, 65, 66, 67, 68, 69, 70, 71,
           72, 73, 74, 75, 76, 77, 78, 79, 80, 81,
           82, 83, 84, 85, 86, 87, 88, 89, 90, 91,
           92, 93, 94, 95, 96, 97, 98, 99,100,101,
        };
        int values3[] =
        {
            1,  2,  3,  4,  5,  6,  7,  8,  9, 10,
           11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
           21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
           31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
           41, 42, 43, 44, 45, 46, 47, 48, 49, 50,
           51, 52, 53, 54, 55, 56, 57, 58, 59, 60,
           61, 62, 63, 64, 65, 66, 67, 68, 69, 70,
           71, 72, 73, 74, 75, 76, 77, 78, 79, 80,
           81, 82, 83, 84, 85, 86, 87, 88, 89, 90,
           91, 92, 93, 94, 95, 96, 97, 98, 99,100,
        };
        STONE_COUNT = sizeof(weights3) / sizeof(weights3[0]);
        
        solver = new KnapsackInfSolver(max_weight, weights3, values3, STONE_COUNT);
        NSLog(@"start");
        NSDate* now = [NSDate date];
        result = solver->solve();
        NSTimeInterval interval = [[NSDate date] timeIntervalSinceDate:now];
        NSLog(@"end. time = %lf", interval);
        // solver->print();
        delete solver;
        
        solverZ = new KnapsackInfSolverZ(max_weight, weights3, values3, STONE_COUNT);
        NSLog(@"start");
        now = [NSDate date];
        result = solverZ->solve();
        interval = [[NSDate date] timeIntervalSinceDate:now];
        NSLog(@"end. time = %lf", interval);
        // solverZ->print();
        delete solverZ;
    }
    return 0;
}
