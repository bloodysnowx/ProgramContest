//
//  FillGasSolverX.h
//  FillGas
//
//  Created by 岩佐 淳史 on 13/04/20.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#ifndef __FillGas__FillGasSolverX__
#define __FillGas__FillGasSolverX__

#include <iostream>

class FillGasSolverX
{
public:
    FillGasSolverX(int* gas, int gas_len, int* distance, int distance_len, int fuelmeter, int goal_distance);
    ~FillGasSolverX();
    int solve();
    void print();
private:
    int* gas;
    int gas_len;
    int* distance;
    int distance_len;
    int goal_distance;
    int solve(int* gas, int gas_len, int* distance, int distance_len, int fuelmeter, int position);
    int fuelmeter;
};

#endif /* defined(__FillGas__FillGasSolverX__) */
