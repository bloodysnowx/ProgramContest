//
//  FoodChainSolver.cpp
//  FoodChain
//
//  Created by 岩佐 淳史 on 2013/05/17.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#include "FoodChainSolver.h"
#include "FoodChainInfoFactory.h"

FoodChainSolver::FoodChainSolver(int animalCount, int* type, int* x, int* y, int length) : animalCount(animalCount), type(type), x(x), y(y), length(length)
{
    tree = new UnionFindTree(animalCount * 3);
    info = new FoodChainInfo*[length];
    for(int i = 0; i < length; ++i)
        info[i] = FoodChainInfoFactory::create(tree, animalCount, type[i], x[i], y[i]);
}

FoodChainSolver::~FoodChainSolver()
{
    delete tree;
    for(int i = 0; i < length; ++i)
        delete info[i];
    delete [] info;
}

int FoodChainSolver::solve()
{
    int answer = 0;
    for(int i = 0; i < length; ++i)
    {
        if(info[i]->isValid()) info[i]->add();
        else
        {
            std::cout << i << " is wrong." << std::endl;
            answer++;
        }
    }
    
    return answer;
}