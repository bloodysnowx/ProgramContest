//
//  FillGasSolverXX.h
//  FillGas
//
//  Created by 岩佐 淳史 on 13/04/21.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#ifndef __FillGas__FillGasSolverXX__
#define __FillGas__FillGasSolverXX__

#include <iostream>
#include <list>
#include "IFillGasSolver.h"

typedef struct {
    int gas;
    int distance;
} GasStation;

class FillGasSolverXX : public IFillGasSolver
{
public:
    FillGasSolverXX(int* gas, int gas_len, int* distance, int distance_len, int fuelmeter, int goal_distance);
    ~FillGasSolverXX();
    int solve();
private:
    std::list<GasStation> gasStations;
    int solve(std::list<GasStation> gasStations, int fuelmeter, int position);
};

#endif /* defined(__FillGas__FillGasSolverXX__) */
