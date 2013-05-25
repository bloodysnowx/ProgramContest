var TwoColorProblemSolver = {
    solve: function(edges) {
        var points = new Array("blue");
        for(var i = 0; i < edges.length; ++i)
        {
            if(points[edges[i][0]] == "blue" && points[edges[i][1]] == "blue") return false;
            else if(points[edges[i][0]] == "red" && points[edges[i][1]] == "red") return false;
            else if(points[edges[i][0]] == "blue") points[edges[i][1]] = "red";
            else if(points[edges[i][0]] == "red") points[edges[i][1]] = "blue";
            else if(points[edges[i][1]] == "blue") points[edges[i][0]] = "red";
            else if(points[edges[i][1]] == "red") points[edges[i][0]] = "blue";
        }
        return true;
    }
};
