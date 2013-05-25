var BinarySearcher = {
    search: function(target, points) {
        return this.searchSub(target, points, 0);
    },
    searchSub: function(target, points, start) {
        if(points.length == 0) return -1;
        if(points.length == 1 && points[0] != target) return -1;
        var centerIndex = parseInt((points.length - 1)/ 2);
        var center = points[centerIndex];
        if(target < center) {
            return this.searchSub(target, points.slice(0, centerIndex), start);
        }
        else if(target == center) {
            return start + centerIndex;
        }
        else {
            return this.searchSub(target, points.slice(centerIndex + 1, points.length), start + centerIndex + 1);
        }
    }
};
