//
//  FoodChainSameInfo.cpp
//  FoodChain
//
//  Created by 岩佐 淳史 on 13/05/19.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#include "FoodChainSameInfo.h"

bool FoodChainSameInfo::isValid()
{
    // xとyが違う種類に存在しない
    return !tree->findSet(x, y + number) && !tree->findSet(x, y + 2 * number);
}

void FoodChainSameInfo::add()
{
    // xとyを同じAとして
    tree->unionSet(x, y);
    // xとyを同じBとして
    tree->unionSet(x + number, y + number);
    // xとyを同じCとして
    tree->unionSet(x + 2 * number, y + 2 * number);
}