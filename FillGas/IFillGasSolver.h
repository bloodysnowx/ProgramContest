//
//  IFillGasSolver.h
//  FillGas
//
//  Created by 岩佐 淳史 on 2013/04/22.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#ifndef __FillGas__IFillGasSolver__
#define __FillGas__IFillGasSolver__

#include <iostream>

class IFillGasSolver
{
public:
    IFillGasSolver(int* gas, int gas_len, int* distance, int distance_len, int fuelmeter, int goal_distance) : gas(gas), gas_len(gas_len), distance(distance), distance_len(distance_len), fuelmeter(fuelmeter), goal_distance(goal_distance) { };
    virtual ~IFillGasSolver() { };
    virtual int solve() = 0;
    void print() { };
protected:
    int* gas;
    int gas_len;
    int* distance;
    int distance_len;
    int goal_distance;
    int fuelmeter;
};

#endif /* defined(__FillGas__IFillGasSolver__) */
