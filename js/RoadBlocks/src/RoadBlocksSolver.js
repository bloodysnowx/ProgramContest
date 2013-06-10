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
                    if(this.first_d[i][j] > this.first_d[i][k] + this.first_d[k][j])
                    {
                        this.second_d[i][j] = this.first_d[i][j];
                        this.first_d[i][j] = this.first_d[i][k] + this.first_d[k][j];
                        this.second_d[i][j] = Math.min(this.second_d[i][j], this.first_d[i][j] + this.second_d[i][i]);
                        this.second_d[i][j] = Math.min(this.second_d[i][j], this.first_d[i][j] + this.second_d[j][j]);
                        this.second_d[i][j] = Math.min(this.second_d[i][j], this.first_d[i][j] + this.second_d[k][k]);
                    }
                    else if(this.second_d[i][j] > this.first_d[i][k] + this.first_d[k][j])
                    {
                        this.second_d[i][j] = this.first_d[i][k] + this.first_d[k][j];
                    }
                }
            }
        }
        return this.second_d[0][V-1];
    },
    setUp: function(V, edges) {
        this.V = V;
        this.edges = edges;
        this.first_d = new Array();
        this.second_d = new Array();
        for(var i = 0; i < V; ++i)
        {
            this.first_d[i] = new Array();
            this.second_d[i] = new Array();
            for(var j = 0; j < V; ++j)
            {
                this.second_d[i][j] = 32767;
                this.first_d[i][j] = 32767;
            }
        }
        for(i = 0; i < edges.length; ++i)
        {
            this.first_d[edges[i][0]][edges[i][1]] = this.first_d[edges[i][1]][edges[i][0]] = edges[i][2];
        }
        for(i = 0; i < V; ++i)
        {
            for(j = 0; j < V; ++j)
            {
                this.second_d[i][i] = Math.min(this.second_d[i][i], this.first_d[i][j] * 2);
            }
        }
    }
};
