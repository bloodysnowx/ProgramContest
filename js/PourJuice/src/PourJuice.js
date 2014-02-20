var Solver = { 
    solve: function(capacities, bottles, fromId, toId) {
        /* 1. bottlesを用意する
           2. 空になる、または、満杯になるまで注ぐ
           3. 2を繰り返す */
        for(var i = 0; i < fromId.length; ++i)
        {
            var result = this.pour2(bottles[fromId[i]], bottles[toId[i]], capacities[toId[i]]);
            bottles[fromId[i]] = result[0];
            bottles[toId[i]] = result[1];
        }
        return bottles;
    }, 
    pour: function(fromAmount, toAmount, toCapacity) {
        return fromAmount + toAmount <= toCapacity ? [0, fromAmount + toAmount] : [fromAmount + toAmount - toCapacity, toCapacity];
    },
    pour2: function(fromAmount, toAmount, toCapacity) {
        var sum = fromAmount + toAmount;
        var toResult = Math.min(sum, toCapacity);
        var fromResult = sum - toResult;
        return [fromResult, toResult];
    }
};
