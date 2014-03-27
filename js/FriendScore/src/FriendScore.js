var Solver = { 
    /* 1. 直接の友達かどうかチェックする
       2. 間接の友達(共通の友人を持つ)かどうかチェックする
       3. カウントアップする
    */
    solve: function(values) {
        var max = 0;
        for(var i = 0; i < values.length; ++i)
            max = Math.max(max, this.countFriend(values, i));
        return max;
    },
    countFriend: function(values, a) {
        var count = 0;
        for(var i = 0; i < values.length; ++i) count += this.isFriend(values, a, i);
        return count;
    },
    isDirectFriend: function(values, a, b) { return values[a][b] == "Y"; },
    isIndirectFriend: function(values, a, b) {
        for(var i = 0; i < values.length; ++i)
            if(a != i && b != i && values[i][a] == "Y" && values[i][b] == "Y") return true;
        return false;
    },
    isFriend: function(values, a, b) { return a != b && (this.isDirectFriend(values, a, b) || this.isIndirectFriend(values, a, b)); }
};
