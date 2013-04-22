//
//  main.m
//  FillGas
//
//  Created by 岩佐 淳史 on 2013/04/19.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "FillGasSolverX.h"
#import "FillGasSolverXX.h"
#import "FillGasSolverXXX.h"

void test(int gas[], int gas_len, int distance[], int fuelmeter, int goal_distance)
{
    int distance_len = gas_len;
    // FillGasSolverXXX* solver = new FillGasSolverXXX(gas, gas_len, distance, distance_len, fuelmeter, goal_distance);
    IFillGasSolver* solver = new FillGasSolverXXX(gas, gas_len, distance, distance_len, fuelmeter, goal_distance);
    int result = solver->solve();
    delete solver;
    NSLog(@"%d", result);
}

int main(int argc, const char * argv[])
{
    @autoreleasepool {
        int gas[] = { 5, 5, 5 };
        int distance[] = { 5, 10, 15 };
        test(gas, 3, distance, 5, 20);
        
        int gas2[] = { 4, 5, 5 };
        test(gas2, 3, distance, 5, 20);
        
        int gas3[] = { 1, 1, 1, 1, 10 };
        int distance3[] = { 1, 2, 3, 4, 5 };
        test(gas3, 5, distance3, 5, 15);
        
        int gas4[] = { 10, 5, 2, 4 };
        int distance4[] = { 10, 14, 20, 21 };
        test(gas4, 4, distance4, 10, 25);

    }
    return 0;
}

