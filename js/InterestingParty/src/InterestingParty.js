var Solver = { 
    solve: function(first, second) {
        /* 1. 辞書を用意する
           2. ヒットした場合カウントアップする
           3. 最大の値を返す */
        return this.countUp(first.concat(second));
    },
    countUp: function(values)
    {
        var dict = {};
        var max = 0;
        for(var i = 0; i < values.length; ++i)
        {
            var value = values[i];
            dict[value] = 1 + (value in dict ? dict[value] : 0);
            max = max > dict[value] ? max : dict[value];
        }
        return max;
    }
};
