//
//  FillGasSolverXX.cpp
//  FillGas
//
//  Created by 岩佐 淳史 on 13/04/21.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#include "FillGasSolverXX.h"



FillGasSolverXX::FillGasSolverXX(int* gas, int gas_len, int* distance, int distance_len, int fuelmeter, int goal_distance) : fuelmeter(fuelmeter), goal_distance(goal_distance)
{
    for(int i = 0; i < gas_len; ++i)
        this->gasStations.push_back({gas[i], distance[i]});
}

FillGasSolverXX::~FillGasSolverXX()
{
    this->gasStations.clear();
}

int FillGasSolverXX::solve()
{
    return this->solve(this->gasStations, this->fuelmeter, 0);
}

void FillGasSolverXX::print()
{
    
}

int FillGasSolverXX::solve(std::list<GasStation> gasStations, int fuelmeter, int position)
{
    // ゴールまで給油無しでたどり着ける
    if(fuelmeter >= this->goal_distance - position) return 0;
    // ゴールにも次のガソリンスタンドにもたどり着けない
    if(gasStations.empty() || gasStations.front().distance - position > fuelmeter) return 65535;
    // ゴールにたどり着けない場合は、もっとも給油量が多いガソリンスタンドで給油する
    std::list<GasStation>::iterator it = gasStations.begin();
    std::list<GasStation>::iterator max_it = it;
    while(it != gasStations.end() || it->distance - position > fuelmeter)
    {
        if(max_it->gas < it->gas) max_it = it;
        ++it;
    }
    fuelmeter += max_it->gas;
    gasStations.erase(max_it);
    
    return 1 + this->solve(gasStations, fuelmeter, 0);
}