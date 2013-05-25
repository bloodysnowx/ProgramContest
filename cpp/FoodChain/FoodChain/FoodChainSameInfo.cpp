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
    return isValidAnimalNumbers() && !tree->findSet(x, y + animalCount) && !tree->findSet(x, y + 2 * animalCount);
}

void FoodChainSameInfo::add()
{
    // xとyを同じAとして
    tree->unionSet(x, y);
    // xとyを同じBとして
    tree->unionSet(x + animalCount, y + animalCount);
    // xとyを同じCとして
    tree->unionSet(x + 2 * animalCount, y + 2 * animalCount);
}