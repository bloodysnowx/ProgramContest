//
//  main.m
//  HowToPart
//
//  Created by 岩佐 淳史 on 2013/04/09.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "HowToPartSolver.h"

int main(int argc, const char * argv[])
{
    @autoreleasepool {
        HowToPartSolver* solver = new HowToPartSolver(20, 20, 10000);
        solver->solve();
        solver->print();
        delete solver;
    }
    return 0;
}

