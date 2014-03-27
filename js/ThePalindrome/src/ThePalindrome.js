var Solver = { 
    /* 1. 先頭と末尾を比較する
       2. 同じならば両者を削除し、長さに2を加える
       3. 違うならば同じになるように文字を挿入する
       4. 長さが1以下になるまで1-3を続ける
       5. 長さを出力して終了
    */
    solve: function(values) {
        var palindrome_len = 0;
        while(values.length > 1) {
            values = values.slice(1, values.length - (values.slice(-1) == values.slice(0, 1)));
            palindrome_len += 2;
        }
        return palindrome_len + values.length;
    }
};
