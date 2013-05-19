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

FoodChainInfo* FoodChainInfoFactory::create(UnionFindTree* tree, int number, int type, int x, int y)
{
    switch (type) {
        case 1:
            return new FoodChainSameInfo(tree, x, y, number);
        case 2:
            return new FoodChainEatInfo(tree, x, y, number);
        default:
            return nullptr;
            break;
    }
}