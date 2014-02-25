var Solver = { 
    solve: function(first, second) {
        /* 1. 辞書を用意する
           2. ヒットした場合カウントアップする
           3. 最大の値を返す */
        var dict = {};
        var max = 0;
        max = this.countUp(first.concat(second), dict, max);
        // max = this.countUp(second, dict, max);
        return max;
    },
    countUp: function(values, dict, max)
    {
        for(var i = 0; i < values.length; ++i)
        {
            var value = values[i];
            dict[value] = 1 + (value in dict ? dict[value] : 0);
            max = max > dict[value] ? max : dict[value];
        }
        return max;
    }
};
