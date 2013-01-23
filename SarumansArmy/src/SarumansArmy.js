var Solver = { 
    solve: function(points, R) {
        /* 1. 最初の点を探す
           2. 最初の点を含める最大の点を探す
           3. 最大の点から円を描き含まれる点を除外し、カウントアップ
           4. 1-3 を繰り返す */
        if(points.length < 1) return 0;

        var startPoint = points[0];
        var nowIndex = 0;

        for(nowIndex = points.length - 1; nowIndex > 0; --nowIndex)
        {
            if(points[nowIndex] - startPoint <= R) break;
        }
        var centerPoint = points[nowIndex];

        for(nowIndex = points.length - 1; nowIndex > 0; --nowIndex)
        {
            if(points[nowIndex] - centerPoint <= R) break;
        }

        points.splice(0, nowIndex + 1);

        return this.solve(points, R) + 1;
    }
};
