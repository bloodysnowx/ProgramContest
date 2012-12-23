// CalcAlignMent.cpp : コンソール アプリケーションのエントリ ポイントを定義します。
//

#include "stdafx.h"

struct S1 {
  short s;
  unsigned char uc[3];
};

struct S2 {
  char string[10];
  unsigned char uc;
};

struct S3 {
  double d;
  long long ll;
  char c;
};

struct S4 {
	double d;
	int i;
};

static const char format2[] = "sizeof(%s)=%d\n";
#define PrintSize(type) printf(format2, #type, (unsigned long)sizeof(type))

typedef union U {
  char string[17];
  double d[2];
} U_t;

int _tmain(int argc, _TCHAR* argv[])
{
	// 基本データ型 (整数型)
	PrintSize(char);
    PrintSize(unsigned char);
	PrintSize(short);
	PrintSize(unsigned short);
	PrintSize(int);
	PrintSize(unsigned int);
	PrintSize(long);
	PrintSize(unsigned long);
	PrintSize(long long);
	PrintSize(unsigned long long);
	printf("\n");

	// 基本データ型 (浮動小数型)
	PrintSize(float);
	PrintSize(double);
	PrintSize(long double);
	printf("\n");

	// ユーザ定義型
	PrintSize(struct S1);
	PrintSize(struct S2);
	PrintSize(struct S3);
	PrintSize(union U);
	PrintSize(struct S4);

	return 0;
}

/* output
sizeof(char)=1
sizeof(unsigned char)=1
sizeof(short)=2
sizeof(unsigned short)=2
sizeof(int)=4
sizeof(unsigned int)=4
sizeof(long)=4
sizeof(unsigned long)=4
sizeof(long long)=8
sizeof(unsigned long long)=8

sizeof(float)=4
sizeof(double)=8
sizeof(long double)=8

sizeof(struct S1)=6
sizeof(struct S2)=11
sizeof(struct S3)=24
sizeof(union U)=24
sizeof(struct S4)=16
*/ 