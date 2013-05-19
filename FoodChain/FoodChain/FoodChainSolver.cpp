//
//  FoodChainSolver.cpp
//  FoodChain
//
//  Created by 岩佐 淳史 on 2013/05/17.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#include "FoodChainSolver.h"
#include "FoodChainInfoFactory.h"

FoodChainSolver::FoodChainSolver(int number, int* type, int* x, int* y, int length) : number(number), type(type), x(x), y(y), length(length)
{
    tree = new UnionFindTree(number * 3);
    info = new FoodChainInfo*[length];
    for(int i = 0; i < length; ++i)
        info[i] = FoodChainInfoFactory::create(tree, number, type[i], x[i], y[i]);
}

FoodChainSolver::~FoodChainSolver()
{
    delete tree;
    for(int i = 0; i < length; ++i)
        delete info[i];
    delete [] info;
}

bool FoodChainSolver::isValidNumber(int number)
{
    return number >= 0 && number < this->number;
}

bool FoodChainSolver::isValidInfo(int i)
{
    return isValidNumber(x[i]) && isValidNumber(y[i]);
}

int FoodChainSolver::solve()
{
    int answer = 0;
    for(int i = 0; i < length; ++i)
    {
        if(isValidInfo(i) == false) {
            answer++;
            continue;
        }
        if(info[i]->isValid()) info[i]->add();
        else answer++;
    }
    
    return answer;
}