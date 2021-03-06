var BruteForceSolver = {
    cache: [null, [[0]], [[1,1]],[[2,2,1]],[[3,3,2,1],[2,2,2,2]]],
    solve: function(points) {
	    var counts = this.countOfUse(points.length);
        var costs = new Array();
        for(var i = 0; i < counts.length; ++i)
        {
            var cost = 0;
            for(var j = 0; j < counts[i].length; ++j)
                cost += points[j] * counts[i][j];
            costs.push(cost);
        }
        return Math.min.apply(null, costs);
    },
    makeComposition: function(a, b) {
        var result = new Array();
        for(var i = 0; i < a.length; ++i)
        {
            for(var j = 0; j < b.length; ++j)
            {
                var tmp = new Array();
                for(var k = 0; k < a[i].length; ++k)
                    tmp.push(1 + a[i][k]);
                for(k = 0; k < b[j].length; ++k)
                    tmp.push(1 + b[j][k]);

                tmp.sort();
                tmp.reverse();
                result.push(tmp);
            }
        }
        return result;
    },
    countOfUse: function(length) {
        if(!this.cache[length])
        {
	        if(length <= 0) return null;
            else
            {
                // 配列の配列を用意する
                var result = new Array();
                // length のカットの仕方
                for(var i = length - 1; i >= length / 2; --i)
                {
                    result = result.concat(this.makeComposition(this.countOfUse(i), this.countOfUse(length - i)));
                }
                this.cache[length] = result;
            }
        }
        return this.cache[length];
    }
};
