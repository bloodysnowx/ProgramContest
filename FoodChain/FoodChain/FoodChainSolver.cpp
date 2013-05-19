//
//  FoodChainSolver.cpp
//  FoodChain
//
//  Created by 岩佐 淳史 on 2013/05/17.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#include "FoodChainSolver.h"

FoodChainSolver::FoodChainSolver(int number, int* type, int* x, int* y, int length) : number(number), type(type), x(x), y(y), length(length)
{
    tree = new UnionFindTree(number * 3);
}

FoodChainSolver::~FoodChainSolver()
{
    delete tree;
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
        // xとyは同じ種類
        if(type[i] == 1) {
            if(tree->findSet(x[i], y[i] + number) || tree->findSet(x[i], y[i] + 2 * number))
            {
                answer++;
            } else {
                tree->unionSet(x[i], y[i]);
                tree->unionSet(x[i] + number, y[i] + number);
                tree->unionSet(x[i] + 2 * number, y[i] + 2 * number);
            }
        // xはyを食べる
        } else if(type[i] == 2) {
            if(tree->findSet(x[i], y[i]) || tree->findSet(x[i], y[i] + 2 + number)) {
                answer++;
            } else {
                tree->unionSet(x[i], y[i] + number);
                tree->unionSet(x[i] + number, y[i] + 2 * number);
                tree->unionSet(x[i] + 2 * number, y[i]);
            }
        } else {
            answer++;
        }
    }
    
    return answer;
}