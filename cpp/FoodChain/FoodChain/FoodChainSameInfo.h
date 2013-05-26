//
//  FoodChainSameInfo.h
//  FoodChain
//
//  Created by 岩佐 淳史 on 13/05/19.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#ifndef __FoodChain__FoodChainSameInfo__
#define __FoodChain__FoodChainSameInfo__

#include <iostream>
#include "FoodChainInfo.h"

class FoodChainSameInfo : public FoodChainInfo
{
public:
    FoodChainSameInfo(UnionFindTree* tree, int x, int y, int animalCount) : FoodChainInfo(tree, x, y, animalCount) { }
    ~FoodChainSameInfo() { };
    bool isValid();
    void add();
};

#endif /* defined(__FoodChain__FoodChainSameInfo__) */
