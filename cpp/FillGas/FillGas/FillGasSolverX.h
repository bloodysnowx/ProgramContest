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
#include "IFillGasSolver.h"

class FillGasSolverX : public IFillGasSolver
{
public:
    FillGasSolverX(int* gas, int gas_len, int* distance, int distance_len, int fuelmeter, int goal_distance) : IFillGasSolver(gas, gas_len, distance, distance_len, fuelmeter, goal_distance) { };
    ~FillGasSolverX() { };
    int solve();
private:
    int solve(int* gas, int gas_len, int* distance, int distance_len, int fuelmeter, int position);
};

#endif /* defined(__FillGas__FillGasSolverX__) */
