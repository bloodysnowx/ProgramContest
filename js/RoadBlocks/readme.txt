1. 最短経路と2番目の経路を探す
2. 最短経路の往復パターンを網羅する
3. 2番目の経路と2で網羅したパターンを比較して、最短のものを出力する

ワーシャル・フロイド
first_d[i][j]を生成する
for(int k = 0; k < V; ++k) {
    for(int i = 0; i < V; ++i) {
        for(int j = 0; j < V; ++j) {
            if(first_d[i][j] > first_d[i][k] + first_d[k][j])
            {
                second_d[i][j] = first_d[i][j];
                first_d[i][j] = first_d[i][k] + first_d[k][j];
            }
            else if(second_d[i][j] > first_d[i][k] + first_d[k][j])
            {
                second_d[i][j] = first_d[i][k] + first_d[k][j];
            }
        }
    }
}
        
second_d[i][j]を生成する
