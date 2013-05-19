//
//  FoodChainInfoFactory.h
//  FoodChain
//
//  Created by 岩佐 淳史 on 13/05/19.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#ifndef __FoodChain__FoodChainInfoFactory__
#define __FoodChain__FoodChainInfoFactory__

#include <iostream>
#include "FoodChainInfo.h"

class FoodChainInfoFactory
{
public:
    static FoodChainInfo* create(UnionFindTree* tree, int number, int type, int x, int y);
};

#endif /* defined(__FoodChain__FoodChainInfoFactory__) */
