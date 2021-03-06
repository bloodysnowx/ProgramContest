var GreedySolver = {
    solve: function(points) {
        if(points.length <= 1) return 0;
        else if(points.length == 2) return points[0] + points[1];
        else
        {
            var newPoint = points.shift()+points.shift();
            points.push(newPoint);
            points.sort(function(a, b) { return a - b; });
            return this.solve(points) + newPoint;
        }
    }
};
