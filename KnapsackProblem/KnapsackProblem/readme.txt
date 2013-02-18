max_weight
waight : w_1, w_2, ... , w_n-1, w_n
value  : v_1, v_2, ... , v_n-1, v_n

Solve(weight[1...n], value[1...n], max_weight)
 = MAX(Solve(weight[1...n-1], value[1...n-1], max_weight), 
 Solve(weight[1...n-1], value[1...n-1], max_weight - weight[n]) + value[n])

1. 
2.
3.
4.
