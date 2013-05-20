//
//  FoodChainInfo.h
//  FoodChain
//
//  Created by 岩佐 淳史 on 13/05/19.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#ifndef __FoodChain__FoodChainInfo__
#define __FoodChain__FoodChainInfo__

#include <iostream>
#include "UnionFindTree.h"

class FoodChainInfo
{
protected:
    UnionFindTree* const tree;
    const int x;
    const int y;
    const int animalCount;
    bool isValidAnimalNumber(int animalNumber);
    bool isValidAnimalNumbers();

public:
    FoodChainInfo(UnionFindTree* tree, int x, int y, int animalCount) : tree(tree), x(x), y(y), animalCount(animalCount) { }
    virtual bool isValid() = 0;
    virtual void add() = 0;
    virtual ~FoodChainInfo() { };
};

#endif /* defined(__FoodChain__FoodChainInfo__) */
