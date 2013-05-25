//
//  main.m
//  FoodChain
//
//  Created by 岩佐 淳史 on 2013/04/22.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "FoodChainSolver.h"

int main(int argc, const char * argv[])
{
    @autoreleasepool {
        int animalCount = 100;
        int length = 7;
        int type[] = { 1, 2, 2, 2, 1, 2, 1 };
        int x[] = { 100, 0, 1, 2, 0, 2, 4 };
        int y[] = { 0, 1, 2, 2, 2, 0, 4 };
        FoodChainSolver* solver = new FoodChainSolver(animalCount, type, x, y, length);
        NSLog(@"answer = %d", solver->solve());
        delete solver;
    }
    return 0;
}

