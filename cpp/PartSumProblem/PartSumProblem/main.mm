//
//  main.m
//  PartSumProblem
//
//  Created by 岩佐 淳史 on 2013/03/08.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "PartSumSolver.h"
#import "PartSumSolverZ.h"
#import "PartSumSolverZZ.h"

IPartSumSolver* create(int target, int values[], int counts[], int length)
{
    return new PartSumSolverZ(target, values, counts, length);
}

int main(int argc, const char * argv[])
{
    @autoreleasepool {
        
        // insert code here...
        NSLog(@"Hello, World!");
        int target = 17;
        int values[] = { 3, 5, 8 };
        int counts[] = { 3, 2, 2 };
        int length = sizeof(values) / sizeof(values[0]);
        IPartSumSolver* solver = create(target, values, counts, length);
        // solver->print();
        bool result = solver->solve();
        solver->print();
        NSLog(@"answer = %@", result ? @"true" : @"false");
        delete solver;
        
        target = 35;
        solver = create(target, values, counts, length);
        // solver->print();
        result = solver->solve();
        solver->print();
        NSLog(@"answer = %@", result ? @"true" : @"false");
        delete solver;
        
        target = 1000;
        int values2[] = { 10, 15, 18, 23, 29, 43, 3, 5, 8, 9, };
        int counts2[] = {  1,  1,  1,  1,  1,  1, 3, 2, 2, 5, };
        length = sizeof(values2) / sizeof(values2[0]);
        solver = create(target, values2, counts2, length);
        result = solver->solve();
        solver->print();
        NSLog(@"answer = %@", result ? @"true" : @"false");
        delete solver;
        
        target = 100000;
        int values3[] = {
            10,  15,  18,  23,  29,  43,   3,   5,   8,   9,
            51,  55,  58,  53,  59,  63,  73,  75,  78,  79,
            81,  85,  88,  83,  99,  93, 103, 105, 108, 109,
           111, 135, 148, 159, 169, 173, 184, 195, 128, 129,
           211, 235, 248, 259, 269, 273, 284, 295, 228, 229,
           311, 335, 348, 359, 369, 373, 384, 395, 328, 329,
           411, 435, 448, 459, 469, 473, 484, 495, 428, 429,
           511, 535, 548, 559, 569, 573, 584, 595, 528, 529,
           611, 635, 648, 659, 669, 673, 684, 695, 628, 629,
           711, 735, 748, 759, 769, 773, 784, 795, 728, 729,
            };
        int counts3[] = {
            1011, 2121, 3131, 4141, 5151, 6161, 7173, 8182, 9192, 5,
            1011, 2121, 3131, 4141, 5151, 6161, 7173, 8182, 9192, 5,
            1011, 2121, 3131, 4141, 5151, 6161, 7173, 8182, 9192, 5,
            1011, 2121, 3131, 4141, 5151, 6161, 7173, 8182, 9192, 5,
            1011, 2121, 3131, 4141, 5151, 6161, 7173, 8182, 9192, 5,
            1011, 2121, 3131, 4141, 5151, 6161, 7173, 8182, 9192, 5,
            1011, 2121, 3131, 4141, 5151, 6161, 7173, 8182, 9192, 5,
            1011, 2121, 3131, 4141, 5151, 6161, 7173, 8182, 9192, 5,
            1011, 2121, 3131, 4141, 5151, 6161, 7173, 8182, 9192, 5,
            1011, 2121, 3131, 4141, 5151, 6161, 7173, 8182, 9192, 5,
        };
        length = sizeof(values3) / sizeof(values3[0]);
        solver = create(target, values3, counts3, length);
        result = solver->solve();
        // solver->print();
        NSLog(@"answer = %@", result ? @"true" : @"false");
        delete solver;
    }
    return 0;
}

