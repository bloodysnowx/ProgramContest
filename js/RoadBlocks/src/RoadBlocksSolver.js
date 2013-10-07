var RoadBlocksSolver = {
    edges: [],
    first_d: [],
    second_d: [],
    points: [0],
    V: 1,
    solve: function(V, edges) {
        this.setUp(V, edges);
        for(var k = 0; k < V; ++k) {
            for(var i = 0; i < V; ++i) {
                for(var j = 0; j < V; ++j) {
                    // 最短経路が更新された場合
                    if(this.first_d[i][j] > this.first_d[i][k] + this.first_d[k][j])
                    {
                        this.second_d[i][j] = this.first_d[i][j];
                        this.first_d[i][j] = this.first_d[i][k] + this.first_d[k][j];
                        // 2番目の経路か？最短経路で反復した場合か？
                        this.second_d[i][j] = Math.min(this.second_d[i][j], this.first_d[i][j] + Math.min(this.second_d[i][i], this.second_d[j][j], this.second_d[k][k]));
                    }
                    // 2番目の経路のみ更新された場合
                    else if(this.second_d[i][j] > this.first_d[i][k] + this.first_d[k][j])
                        this.second_d[i][j] = this.first_d[i][k] + this.first_d[k][j];
                }
            }
        }
        return this.second_d[0][V-1];
    },
    setUp: function(V, edges) {
        this.V = V;
        this.edges = edges;
        // 2次元配列の準備
        this.first_d = new Array();
        this.second_d = new Array();
        for(var i = 0; i < V; ++i)
        {
            this.first_d[i] = new Array();
            this.second_d[i] = new Array();
            for(var j = 0; j < V; ++j)
            {
                // 初期値をセット
                this.second_d[i][j] = Number.POSITIVE_INFINITY;
                this.first_d[i][j] = Number.POSITIVE_INFINITY;
            }
        }
        // パスでつながっているところに設定
        for(i = 0; i < edges.length; ++i)
            this.first_d[edges[i][0]][edges[i][1]] = this.first_d[edges[i][1]][edges[i][0]] = edges[i][2];
        // 反復する部分を算出
        for(i = 0; i < V; ++i)
            for(j = 0; j < V; ++j)
                this.second_d[i][i] = Math.min(this.second_d[i][i], this.first_d[i][j] * 2);
    }
};
