//
//  FoodChainInfo.cpp
//  FoodChain
//
//  Created by 岩佐 淳史 on 13/05/19.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#include "FoodChainInfo.h"

bool FoodChainInfo::isValidAnimalNumber(int animalNumber)
{
    return animalNumber >= 0 && animalNumber < this->animalCount;
}

bool FoodChainInfo::isValidAnimalNumbers()
{
    return isValidAnimalNumber(this->x) && isValidAnimalNumber(this->y);
}
