//
//  FoodChainEatInfo.h
//  FoodChain
//
//  Created by 岩佐 淳史 on 13/05/19.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#ifndef __FoodChain__FoodChainEatInfo__
#define __FoodChain__FoodChainEatInfo__

#include <iostream>
#include "FoodChainInfo.h"

class FoodChainEatInfo : public FoodChainInfo
{
public:
    FoodChainEatInfo(UnionFindTree* tree, int x, int y, int animalCount) : FoodChainInfo(tree, x, y, animalCount) { }
    ~FoodChainEatInfo() { };
    bool isValid();
    void add();
};

#endif /* defined(__FoodChain__FoodChainEatInfo__) */
