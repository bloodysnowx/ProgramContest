//
//  FillGasSolverXXX.h
//  FillGas
//
//  Created by 岩佐 淳史 on 2013/04/22.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#ifndef __FillGas__FillGasSolverXXX__
#define __FillGas__FillGasSolverXXX__

#include <iostream>
#include <queue>
#include "IFillGasSolver.h"

class FillGasSolverXXX : public IFillGasSolver
{
public:
    FillGasSolverXXX(int* gas, int gas_len, int* distance, int distance_len, int fuelmeter, int goal_distance) : IFillGasSolver(gas, gas_len, distance, distance_len, fuelmeter, goal_distance) { };
    ~FillGasSolverXXX() { };
    int solve();
private:
    std::priority_queue<int> gasStations;
    int solve(int* gas, int gas_len, int* distance, int distance_len, std::priority_queue<int> gasStations, int fuelmeter, int position);
};

#endif /* defined(__FillGas__FillGasSolverXXX__) */
