lcs_len[i][j] = (a[i - 1] == b[j - 1] && lcs_len[i][j-1] == lcs_len[i-1][j]) ? lcs_len[i][j - 1] + 1 : MAX(lcs_len[i][j-1], lcs_len[i-1][j]);

Solve(a_1...a_n, b_1...b_m)
= MAX(Solve(a_1...a_n-1, b_1...b_m) + 0 or 1, Solve(a_1...a_n, b_1...b_m-1) + 0 or 1)
1となる条件
(a_n == a_m) && (Solve(a_1...a_n-1, b_1...b_m) == Solve(a_1...a_n, b_1...b_m-1))