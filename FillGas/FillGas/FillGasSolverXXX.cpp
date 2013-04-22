//
//  FillGasSolverXXX.cpp
//  FillGas
//
//  Created by 岩佐 淳史 on 2013/04/22.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#include "FillGasSolverXXX.h"

int FillGasSolverXXX::solve()
{
    return this->solve(this->gas, this->gas_len, this->distance, this->distance_len, this->gasStations, this->fuelmeter, 0);
}

int FillGasSolverXXX::solve(int* gas, int gas_len, int* distance, int distance_len, std::priority_queue<int> gasStations, int fuelmeter, int position)
{
    // 1. 走れるだけ走る
    position += fuelmeter;
    fuelmeter = 0;
    // 2. ゴールに到着すれば終了する
    if(position >= this->goal_distance) return 0;
    // 3. 途中でガソリンスタンドを通過したら、ガソリン量をpriority_queueにpushする
    int i;
    for(i = 0; i < gas_len; ++i)
    {
        if(distance[i] > position) break;
        gasStations.push(gas[i]);
    }
    // 4. ガソリンが切れたら、queueからpopして、1へ
    if(gasStations.empty()) return 65535;
    fuelmeter += gasStations.top();
    gasStations.pop();
    return 1 + this->solve(gas + i, gas_len - i, distance + i, distance_len - i, gasStations, fuelmeter, position);
}