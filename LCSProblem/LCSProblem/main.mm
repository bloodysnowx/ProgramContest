//
//  main.m
//  LCSProblem
//
//  Created by 岩佐 淳史 on 13/02/25.
//  Copyright (c) 2013年 岩佐 淳史. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "LCSSolver.h"
#include <string.h>

void test(const char* a, const char* b)
{
    size_t a_len = strlen(a);
    size_t b_len = strlen(b);
    LCSSolver* solver = new LCSSolver(a, b, a_len, b_len);
    int answer = solver->solve();
    solver->print();
    NSLog(@"%d", answer);
    delete solver;
}

int main(int argc, const char * argv[])
{

    @autoreleasepool {

        test("abc", "cba");
        test("abcd", "bcde");
        test("abcd", "becd");
        test("ABCBDAB", "BDCABA");
        test("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
             "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
        test("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
             "bbbbbbbbbbbbbabbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbb");
        /*test("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
             "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
        test("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
             "bbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbbbbbbbbbbb");
        test("abcdefkgaeoiuaoeiuaoiegjaegja;gja;ioergaoigruajoergija:",
             "awuept0a9uey0@9se6b934n8-bwwbtw45b,w-0e,vre");
        test("abcdefkgaaopuga0ga@90etq09t8q34t39ghsjb:seoiuaoeiuaoiegjaegja;gja;ioergaoigruajoergija:",
             "awuept0a9uey0@9se6b934n8-g9u@eogira@ogriljsl:rgja:e;rgja:ergj:aeopig:jo:ergjpae:gjaegijop:bwwbtw45b,w-0e,vre");
    */test("abcdefkgaaopuga0ga@90etq09t8q34t39ghsjb:seoiuaoaioerta@ogjalrgja;ieja;logh:weirgt;o9erghaew:rigaer:pg:jergjergijoper;ghergje@09tuw-30457234tgoezl:rgeifilapo4t;aowt;aeworigpae9f;eowtuqw4uaoiegjaegja;gja;ioergaoigruajoergija:",
         "awuept0a9uey0@9se6b934n8g9u@eogisidfhapw;etyq@9w8rtyqp394tyq34poth@3490tra@ogriljsl:rgja:e;q49tuporghpaeortu;eorg;eoirgup0eutergj:eaprg;wo4itg;erijg;erigjesriug3r8tupew9rgu@ewrgja:ergj:aeopig:jo:ergjpae:gjaegijop:bwwbtw45b,w-0e,vre");
    }
    return 0;
}

