//
//  HowToPartSolver.cpp
//  HowToPart
//
//  Created by 岩佐 淳史 on 2013/04/09.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#include "HowToPartSolver.h"
#include <iomanip>
#include <iostream>

HowToPartSolver::HowToPartSolver(int number, int part, int mod) : number(number), part(part), mod(mod)
{
    // i = 0...number
    // j = 1...part
    DPTable = new int*[number + 1];
    for(int i = 0; i < number + 1; ++i)
    {
        DPTable[i] = new int[part];
        DPTable[i][0] = 1;
    }
    for(int j = 0; j < part; ++j)
        DPTable[0][j] = DPTable[1][j] = 1;
}

int HowToPartSolver::solve()
{
    for(int i = 2; i < number + 1; ++i)
    {
        for(int j = 1; j < part; ++j)
        {
            DPTable[i][j] = 0;
            // f(n, m) = f(n-1, 1) + f(n-2, 2) + ... + f(0, m-n)
            //      or = f(n-1, 1) + f(n-2, 2) + ... + f(n-m, m)
            for(int k = 0; i - k  - 1 >= 0 && k <= j; ++k)
            {
                DPTable[i][j] += DPTable[i - k - 1][k];
            }
        }
    }
    return DPTable[number][part - 1];
}

int HowToPartSolver::solveZ()
{
    for(int i = 2; i < number + 1; ++i)
    {
        for(int j = 1; j < part; ++j)
        {
            DPTable[i][j] = DPTable[i][j-1];
            if(i - j - 1 >= 0) DPTable[i][j] = (DPTable[i - j - 1][j] + DPTable[i][j]) % mod;
        }
    }
    return DPTable[number][part - 1];
}

HowToPartSolver::~HowToPartSolver()
{
    for(int i = 0; i < number + 1; ++i)
        delete[] DPTable[i];
    delete[] DPTable;
}

void HowToPartSolver::print()
{
    /*
    for(int i = 1; i < number + 1; ++i)
    {
        for(int j = 0; j < part; ++j)
        {
            std::cout << std::setw(2) << DPTable[i][j] << ' ';
        }
        std::cout << std::endl;
    }
    */
    for(int j = 0; j < part; ++j)
    {
        for(int i = 1; i < number + 1; ++i)
        {
            std::cout << std::setw(2) << DPTable[i][j] << ' ';
        }
        std::cout << std::endl;
    }
}