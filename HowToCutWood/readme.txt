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

二分木なので a と b は常にセット

a, b -> (1,1) (a+b)
a, b, c -> (2,1) 2(a+b)+c
a, b, c, d -> (3,1) 3(a+b)+2c+d  = 3x+2c+d
              (2,2) 2(a+b)+2c+2d = 2x+2c+2d
a, b, c, d, e -> (4,1) 4(a+b)+3c+2d+e  = 4x+3c+2d+e
                       3(a+b)+3c+3d+e  = 3x+3c+3d+e
                 (3,2) 3(a+b)+2c+2d+2e = 3x+2c+2c+2e
a, b, c, d, e, f -> (5,1) 5(a+b)+4c+3d+2e+f = 5x+4c+3d+2e+f
                          4(a+b)+4c+4d+2e+f 
                          4(a+b)+3c+3d+3e+f  
                    (4,2) 4(a+b)+3c+2d+2e+2f 
                          3(a+b)+3c+3d+2e+2f 
                    (3,3) 3(a+b)+3c+3d+2e+2f 
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
