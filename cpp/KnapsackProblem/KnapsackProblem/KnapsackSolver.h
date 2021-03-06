//
//  KnapsackSolver.h
//  KnapsackProblem
//
//  Created by 岩佐 淳史 on 13/02/18.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "IKnapsackSolver.h"

class KnapsackSolver : public IKnapsackSolver
{
public:
    KnapsackSolver();
    KnapsackSolver(int max_weight, int weights[], int values[], int length);
    int solve();
    ~KnapsackSolver();
    int solve(int max_weight, int weights[], int values[], int length);
private:
    int** sums;
};
