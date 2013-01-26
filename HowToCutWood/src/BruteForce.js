var BruteForceSolver = {
    cache: {},
    solve: function(points) {
	
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
	    if(length <= 1) return [[0]];
	    else if(length == 2) return [[1,1]];
	    else if(length == 3) return [[2,2,1]];
	    else if(length == 4) return [[3,3,2,1],[2,2,2,2]];
        else
        {
            // 配列の配列を用意する
            var result = new Array();
            // length のカットの仕方
            for(var i = length - 1; i >= length / 2; --i)
            {
                result.concat(makeComposition(countOfUse(i), countOfUse(length - i)));
            }
            return result;
        }
    }
};
