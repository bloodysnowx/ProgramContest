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

typedef struct {
    int gas;
    int distance;
} GasStation;

class FillGasSolverXX
{
public:
    FillGasSolverXX(int* gas, int gas_len, int* distance, int distance_len, int fuelmeter, int goal_distance);
    ~FillGasSolverXX();
    int solve();
    void print();
private:
    // std::list<int> gas;
    // std::list<int> distance;
    std::list<GasStation> gasStations;
    int goal_distance;
    int solve(std::list<GasStation> gasStations, int fuelmeter, int position);
    int fuelmeter;
};

#endif /* defined(__FillGas__FillGasSolverXX__) */
