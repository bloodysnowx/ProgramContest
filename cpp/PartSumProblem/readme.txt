Answer(x) = Solve(x, a1, ... , am, n1, ... , nm)
          = Max(Solve(x - a1, a1, ... , am, n1-1, ... , nm), ... , Solve(x - am, a1, ... , am, n1, ... , nm-1))
       
Answer(0) = 1
Answer(1) = ...
...
Answer(x) = ...

-----

Answer(x, m) = Solve(x, a1, ... , am, n1, ... , nm)
             = Max(Solve(x, a1, ... , am-1, n1, ... , nm), Solve(x - am, a1, ... , am-1, n1, ... , nm - 1), ... ,
             Solve(x - am * nm, a1, ... , am-1, n1, ... , nm - nm))
          
Answer(x, 0) = 0
Answer(x, 1) = ...
...
Answer(x, m) = ...


-----

Answer(x) = Solve(x, a1, ... , am, n1, ... , nm)

dp[i + 1][j] = mi(dp[i][j]>=0) or -1(j<ai or dp[i+1][j-ai] <= 0) or dp[i + 1][j - ai] - 1

