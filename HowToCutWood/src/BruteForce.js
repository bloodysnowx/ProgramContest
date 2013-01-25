var BruteForceSolver = {
    solve: function(points) {
	
    },
    countOfUse: function(length) {
	if(length <= 1) return [[0]];
	else if(length == 2) return [[1,1]];
	else if(length == 3) return [[2,2,1]];
	else if(length == 4) return [[3,3,2,1],[2,2,2,2]];
    }
};
