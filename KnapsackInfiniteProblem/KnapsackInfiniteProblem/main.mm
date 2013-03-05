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
        solver->print();
        delete solver;
        
        KnapsackInfSolverZ* solverZ = new KnapsackInfSolverZ(max_weight, weights, values, STONE_COUNT);
        result = solverZ->solve();
        solverZ->print();
        delete solverZ;
        
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
        
        solver = new KnapsackInfSolver(max_weight, weights2, values2, STONE_COUNT);
        result = solver->solve();
        solver->print();
        delete solver;
        
        solverZ = new KnapsackInfSolverZ(max_weight, weights2, values2, STONE_COUNT);
        result = solverZ->solve();
        solverZ->print();
        delete solverZ;
        
        max_weight = 20;
        int weights3[] =
        {
            2,  3,  4,  5,  6,  7,  8,  9, 10, 11
        };
        int values3[] =
        {
            1,  2,  3,  4,  5,  6,  7,  8,  9, 10
        };
        STONE_COUNT = sizeof(weights3) / sizeof(weights3[0]);
        
        solver = new KnapsackInfSolver(max_weight, weights3, values3, STONE_COUNT);
        result = solver->solve();
        solver->print();
        delete solver;
        
        solverZ = new KnapsackInfSolverZ(max_weight, weights3, values3, STONE_COUNT);
        result = solverZ->solve();
        solverZ->print();
        delete solverZ;
    }
    return 0;
}
