//
//  FillGasSolverX.cpp
//  FillGas
//
//  Created by 岩佐 淳史 on 13/04/20.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#include "FillGasSolverX.h"

FillGasSolverX::FillGasSolverX(int* gas, int gas_len, int* distance, int distance_len, int fuelmeter, int goal_distance) : gas(gas), gas_len(gas_len), distance(distance), distance_len(distance_len), fuelmeter(fuelmeter), goal_distance(goal_distance)
{
    
}

FillGasSolverX::~FillGasSolverX()
{
    
}

int FillGasSolverX::solve()
{
    return this->solve(this->gas + 0, this->gas_len + 0, this->distance + 0, this->distance_len + 0, this->fuelmeter + 0, 0);
}

void FillGasSolverX::print()
{
    
}

int FillGasSolverX::solve(int* gas, int gas_len, int* distance, int distance_len, int fuelmeter, int position)
{
    // ゴールまで給油無しでたどり着ける
    if(fuelmeter >= goal_distance - position) return 0;
    // ゴールにも次のガソリンスタンドにもたどり着けない
    if(distance_len == 0 || distance[0] - position > fuelmeter) return 65535;
    // 次のガソリンスタンドで給油した場合と給油しない場合で、回数の少ない方が正解
    int through = solve(gas + 1, gas_len - 1, distance + 1, distance_len - 1, fuelmeter - (distance[0] - position), distance[0]);
    int filled = solve(gas + 1, gas_len - 1, distance + 1, distance_len - 1, fuelmeter - (distance[0] - position) + gas[0], distance[0]) + 1;
    return MIN(through, filled);
}