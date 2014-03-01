var Solver = { 
    solve: function(values) {
        /* 1. 積を計算する
           2. 最大値を保存する */
        var prod = values.reduce(function (a, b) { return a * b; }, 1);
        var calculated = values.map(function(x) { return prod * (x + 1) / x; });
        return Math.max.apply(null, calculated);
    },
    solve2: function(values) {
        return Math.max.apply(null, values.map(function(x) { return values.reduce(function (a, b) { return a * b; }, 1) * (x + 1) / x; }));
    }
};
