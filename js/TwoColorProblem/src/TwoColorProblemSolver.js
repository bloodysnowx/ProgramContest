var TwoColorProblemSolver = {
    color: ["blue", "red", "yellow"],
    points: [],
    solve: function(edges) {
        for(var i = 0; i < edges.length; ++i)
        {
            if(this.points[edges[i][0]] == this.color[0] && this.points[edges[i][1]] == this.color[0]) return false;
            else if(this.points[edges[i][0]] == this.color[1] && this.points[edges[i][1]] == this.color[1]) return false;
            else if(this.points[edges[i][0]] == this.color[0]) this.points[edges[i][1]] = this.color[1];
            else if(this.points[edges[i][0]] == this.color[1]) this.points[edges[i][1]] = this.color[0];
            else if(this.points[edges[i][1]] == this.color[0]) this.points[edges[i][0]] = this.color[1];
            else if(this.points[edges[i][1]] == this.color[1]) this.points[edges[i][0]] = this.color[0];
            else { this.points[edges[i][0]] = this.color[0]; this.points[edges[i][1]] = this.color[1];}
        }
        return true;
    }
};
