//
//  HowToPartSolver.h
//  HowToPart
//
//  Created by 岩佐 淳史 on 2013/04/09.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#ifndef __HowToPart__HowToPartSolver__
#define __HowToPart__HowToPartSolver__

#include <iostream>

class HowToPartSolver
{
public:
    HowToPartSolver(int number, int part, int mod);
    int solve();
    ~HowToPartSolver();
    void print();
    int solveZ();
private:
    const int number;
    const int part;
    const int mod;
    int** DPTable;
};

#endif /* defined(__HowToPart__HowToPartSolver__) */
