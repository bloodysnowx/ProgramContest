var FirstBinarySearcher = {
    search: function(target, points) {
        if(points.length <= 0) return -1;
        var low = 0;
        var high = points.length - 1;
        while(low <= high) {
            var mid = parseInt((high - low) / 2) + low;
            if(target < points[mid]) high = mid - 1;
            else if(target == points[mid]) return mid;
            else if(target > points[mid]) low = mid + 1;
        }
        return -1;
    }
};


