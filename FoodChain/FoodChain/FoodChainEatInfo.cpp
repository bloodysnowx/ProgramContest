//
//  FoodChainEatInfo.cpp
//  FoodChain
//
//  Created by 岩佐 淳史 on 13/05/19.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#include "FoodChainEatInfo.h"

bool FoodChainEatInfo::isValid()
{
    // xとyが同じ種類に存在しない、かつ、yがxを食べる関係ではない
    return !tree->findSet(x, y) && !tree->findSet(x, y + 2 + number);
}

void FoodChainEatInfo::add()
{
    // xがAとしてBであるyを食べる
    tree->unionSet(x, y + number);
    // xがBとしてCであるyを食べる
    tree->unionSet(x + number, y + 2 * number);
    // xがCとしてAであるyを食べる
    tree->unionSet(x + 2 * number, y);
}