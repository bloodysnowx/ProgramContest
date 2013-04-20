//
//  GasStationTree.h
//  FillGas
//
//  Created by 岩佐 淳史 on 13/04/20.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#ifndef __FillGas__GasStationTree__
#define __FillGas__GasStationTree__

#include <iostream>

class GasStationTree
{
public:
    GasStationTree();
    ~GasStationTree();
private:
    GasStationTree* filled;
    GasStationTree* through;
    int fuelmeter;
    int position;
    int filledCount;
};

#endif /* defined(__FillGas__GasStationTree__) */
