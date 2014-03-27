var Solver = { 
    /* 1. 直接の友達かどうかチェックする
       2. 間接の友達(共通の友人を持つ)かどうかチェックする
       3. カウントアップする
    */
    solve: function(values) { return Math.max.apply(null, this.range(0, values.length).map(function(x) { return this.countFriend(values, x); }, this)); },
    countFriend: function(values, a) { return this.sum(this.range(0, values.length).map(function(x) { return this.isFriend(values, a, x); }, this)); },
    isDirectFriend: function(values, a, b) { return values[a][b] == "Y"; },
    isIndirectFriend: function(values, a, b) { return Math.max.apply(null, this.range(0, values.length).map(function(x) { return a != x && b != x && values[x][a] == "Y" && values[x][b] == "Y"; })); },
    isFriend: function(values, a, b) { return a != b && (this.isDirectFriend(values, a, b) || this.isIndirectFriend(values, a, b)); },
    range: function(begin, end) { return Array.apply(null, {length: end - begin}).map(Number.call, Number).map(function(x) { return x + begin; }); },
    sum: function(values) { return values.reduce(function(x, y) { return x + y; }); }
};
