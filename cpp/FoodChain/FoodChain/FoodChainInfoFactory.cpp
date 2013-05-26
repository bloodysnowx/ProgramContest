//
//  FoodChainInfoFactory.cpp
//  FoodChain
//
//  Created by 岩佐 淳史 on 13/05/19.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#include "FoodChainInfoFactory.h"
#include "FoodChainSameInfo.h"
#include "FoodChainEatInfo.h"

FoodChainInfo* FoodChainInfoFactory::create(UnionFindTree* tree, int animalCount, int type, int x, int y)
{
    switch (type) {
        case 1:
            return new FoodChainSameInfo(tree, x, y, animalCount);
        case 2:
            return new FoodChainEatInfo(tree, x, y, animalCount);
        default:
            return nullptr;
            break;
    }
}