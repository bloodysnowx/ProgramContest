共通部分 : same

a <= b <= c <= d <= e <= ...

a, b -> (1,1) a+b
a, b, c -> (2,1) 2a+2b+c
a, b, c, d -> (3,1) 3a+3b+2c+d  = same + a+b
              (2,2) 2a+2b+2c+2d = same + d
(a+b) と d の比較
a, b, c, d, e -> (4,1) 4a+4b+3c+2d+e  = same + a+b+c
                       3a+3b+3c+3d+e  = same + c+d
                 (3,2) 3a+3b+2c+2d+2e = same + e
(a+b+c) と (c+d) と e の比較
a, b, c, d, e, f -> (5,1) 5a+5b+4c+3d+2e+f  = same + 2a+2b+c+d
                          4a+4b+4c+4d+2e+f  = same + a+b+c+2d
                          4a+4b+3c+3d+3e+f  = same + a+b+d+e
                    (4,2) 4a+4b+3c+2d+2e+2f = same + a+b+f
                          3a+3b+3c+3d+2e+2f = same + d+f
                    (3,3) 3a+3b+3c+3d+2e+2f = same + d+f
(2a+2b+c+d) と (a+b+c+2d) と (a+b+d+e) と (a+b+f) と (d+f) の比較
a, b, c, d, e, f, g -> (6,1) 6a+6b+5c+4d+3e+2f+g  = same + 3a+3b+2c+d+e
                             5a+5b+5c+5d+3e+2f+g  = same +
                             5a+5b+4c+4d+4e+2f+g  = same + 
                             5a+5b+4c+3d+3e+3f+g  = same + 
                             4a+4b+4c+4d+3e+3f+g  = same + 
                       (5,2) 5a+5b+4c+3d+2e+2f+2g = same + 
		             4a+4b+4c+4d+2e+2f+2g = same + 
			     4a+4b+3c+3d+3e+2f+2g = same + 
                       (4,3) 4a+4b+3c+3d+3e+2f+2g = same + 
		             3a+3b+3c+3d+3e+3f+2g = same + 

数列 {a_n}

1. {a_n}に対して可能な分割パターンを算出する -> 二分木
2. 各パターン内で最小コストを算出する
3. 算出されたコスト群の中で最小を選択する
-> BruteForceSolver

二分木なので a と b は常にセット

a, b -> (1,1) (a+b)
a, b, c -> (2,1) 2(a+b)+c = x+(x+d)
         = x + (1, 1)
a, b, c, d -> (3,1) 3(a+b)+2c+d  = x+(2x+2c+d) = x+(2(x+c)+d) -> (((a,b),c),d)
              (2,2) 2(a+b)+2c+2d = x+(x+2c+2d) = x+(x+2(c+d)) -> ((a,b),(c,d))
            = x + (2, 2, 1)
(a+b)=x と d の比較
x+(x, c, d)のパターン

a, b, c, d, e -> (4,1) 4(a+b)+3c+2d+e  = x+(3x+3c+2d+e)
                       3(a+b)+3c+3d+e  = x+(2x+3c+3d+e)
               = x + (3, 3, 2, 1)
                 (3,2) 3(a+b)+2c+2d+2e = x+(2x+2c+2c+2e)
               = x + (2, 2, 2, 2)
x+(x, c, d, e)のパターン

a, b, c, d, e, f -> (5,1) 5(a+b)+4c+3d+2e+f = x+(4x+4c+3d+2e+f)
                          4(a+b)+4c+4d+2e+f = x+(3x+4c+4d+2e+f)
                          4(a+b)+3c+3d+3e+f = x+(3x+3c+3d+3e+f)
                    (4,2) 4(a+b)+3c+2d+2e+2f = x+(3x+3c+2d+2e+2f)
                          3(a+b)+3c+3d+2e+2f = x+(2x+3c+3d+2e+2f)
                    (3,3) 3(a+b)+3c+3d+2e+2f = x+(2x+3c+3d+2e+2f)
a, b, c, d, e, f, g -> (6,1) 6(a+b)+5c+4d+3e+2f+g 
                             5(a+b)+5c+5d+3e+2f+g 
                             5(a+b)+4c+4d+4e+2f+g 
                             5(a+b)+4c+3d+3e+3f+g 
                             4(a+b)+4c+4d+3e+3f+g 
                       (5,2) 5(a+b)+4c+3d+2e+2f+2g
		             4(a+b)+4c+4d+2e+2f+2g
			     4(a+b)+3c+3d+3e+2f+2g
                       (4,3) 4(a+b)+3c+3d+3e+2f+2g
		             3(a+b)+3c+3d+3e+3f+2g

1,2,3,4,5,6 -> (1,2),3,4,5,6 -> ((1,2),3),4,5,6 -> ((1,2),3),(4,5),6 -> (((1,2),3),6),(4,5)

1,2,4,8 -> (1,2),4,8 -> ((1,2),4),8 = 15+7+3 = 25
1,1,1,2 ->

P(a, b) = a + b
P(a, b, c) = 2a + 2b + c = a + b + P(a + b, c)
if(a + b <= d)
P(a, b, c, d) = 3a + 3b + 2c + d = a + b + P(a + b, c, d) or a + b + P(c, d, a + b)
if(a + b > d)
P(a, b, c, d) = 2a + 2b + 2c + 2d = a + b + P(c, d, a + b)
if(a + b <= d && a + b + c <= e)
P(a, b, c, d, e) = 4a + 4b + 3c + 2d +e = a + b + P(a + b, c, d, e)
if(d <= a + b && c + d <= e)
P(a, b, c, d, e) = 3a + 3b + 3c + 3d +e = a + b + P(c, d, a + b, e)
if(e <= (a + b) + c && e <= c + d)
P(a, b, c, d, e) = 3a + 3b + 2c + 2d + 2e = a + b + P(c, d, e, a + b)

一般にが成立する？
P(x_1, x_2, ... , x_n) = x_1 + x_2 + P(x_1 + x_2, ... , x_n)
 -> GreedySolver

一般に係数をa_1, a_2, ... , a_nとして
P(x_1, x_2, ... , x_n) = a_1 * x_1 + a_2 * x_2 + ... + a_n * x_n
x_1 <= x_2 <= x_3 <= ... <= x_k <= x_k+1 となるようにソートしておけば、
a_1 >= a_2 >= a_3 >= ... >= a_k >= a_k+1 となった場合が最小になる
二分木なので a_1 == a_2 が成立
P(x_1, x_2, x_3, ... , x_n) = x_1 + x_2 + (a_1 - 1) * (x_1 + x_2) + ... + a_n * x_n
x_1 + x_2 を除いた部分は n-1 の場合の二分木なので、P(x_1 + x_2, x_3, ... , x_n)と表わせる
よって、
P(x_1, x_2, x_3, ... , x_n) = x_1 + x_2 + P(x_1 + x_2, x_3, ... , x_n)




































P(x_1, x_2, ... , x_n) = x_1 + x_2 + P(x_1 + x_2, ... , x_n)
を仮定

n <= 5 では成立

n <= k で成立すると仮定
P(x_1, x_2, x_3, ... , x_k) = a_1 * x_1 + a_2 * x_2 + ... + a_k * x_k
                            = x_1 + x_2 + (a_1 - 1) * (x_1 + x_2) + ... + a_k * x_k
                            = x_1 + x_2 + P(x_1 + x_2, x_3, ... , x_k)
n = k+1 の時
P(x_1, x_2, x_3, ... , x_k, x_k+1) = a_1 * x_1 + a_2 * x_2 + ... + a_k * x_k + a_k+1 * x_k+1
x_1 <= x_2 <= x_3 <= ... <= x_k <= x_k+1 としているので、
a_1 >= a_2 >= a_3 >= ... >= a_k >= a_k+1 となった場合が最小
二分木なので a_1 == a_2 が成立
P(x_1, x_2, x_3, ... , x_k, x_k+1) = x_1 + x_2 + (a_1 - 1) * (x_1 + x_2) + ... + a_k * x_k + a_k+1 * x_k+1
x_1 + x_2 を除いた部分は k の場合の二分木なので、P(x_1 + x_2, x_3, ... , x_k, x_k+1)と表わせる
よって、
P(x_1, x_2, x_3, ... , x_k, x_k+1) = x_1 + x_2 + P(x_1 + x_2, x_3, ... , x_k, x_k+1)
