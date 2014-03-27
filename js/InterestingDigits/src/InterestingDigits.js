var Solver = { 
    /* 1. [2, 3, ... , n-1]の配列を用意する
       2. 3桁の数字を総あたりする
       3. 配列内の数字の倍数かどうかを判定する
       4. 全桁の合計が数字の倍数かどうかを判定する
       5. 倍数でなければ、配列から削除する
       6. 全探索終了後配列を返す
    */
    solve: function(base) {
        var interestingNumbers = this.range(2, base);
        var number = this.range(0, base);
        var allNumbers = this.cartesianProduct(number, number, number);
        for(var i = 0; i < allNumbers.length; ++i) {
            for(var j = interestingNumbers.length - 1; j >= 0; --j) {
                if(this.isDivisor(interestingNumbers[j], allNumbers[i], base) && allNumbers[i].reduce(function(x, y) { return x + y; }, 0) % interestingNumbers[j] != 0) interestingNumbers.splice(j, 1);
            }
        }
        return interestingNumbers;
    },
    range: function(begin, end) { return Array.apply(null, {length: end - begin}).map(Number.call, Number).map(function(x) { return x + begin; }); },
    cartesianProductSub: function(a, b) {
        var prod = a.map(function(x) { return b.map(function(y) { return x instanceof Array ? x.concat(y) : [x, y]; }); });
        return prod.reduce(function(x, y) { return x.concat(y); });
    },
    cartesianProduct: function() { return [].slice.apply(arguments).reduce(function(a, b) { return Solver.cartesianProductSub(a, b); }); },
    isDivisor: function(x, numbers, base) { return numbers.reduce(function(a, b)  { return a * base + b; }, 0) % x == 0; }
};
