TestCase("BruteForceSolverTest", {
    setUp: function() {
	    this.solver = Object.create(BruteForceSolver);
    },

    "test makeComposition [[0]],[[0]] should return [[1,1]]": function() {
        var result = this.solver.makeComposition([[0]],[[0]]);
        assertEquals([[1,1]], result);
    },
    "test makeComposition [[1,1]],[[0]] should return [[2,2,1]]": function() {
        var result = this.solver.makeComposition([[1,1]],[[0]]);
        assertEquals([[2,2,1]], result);
    },
    "test makeComposition [[1,1]],[[1,1]] should return [[2,2,2,2]]": function() {
        var result = this.solver.makeComposition([[1,1]],[[1,1]]);
        assertEquals([[2,2,2,2]], result);
    },
    "test makeComposition [[1,1],[2]],[[0]] should return [[2,2,1],[3,1]]": function() {
        var result = this.solver.makeComposition([[1,1],[2]],[[0]]);
        assertEquals([[2,2,1],[3,1]], result);
    },
    "test makeComposition [[3,3,2,1],[2,2,2,2]],[[3,3,2,1],[2,2,2,2]] should return [[4,4,4,4,3,3,2,2],[4,4,3,3,3,3,3,2],[4,4,3,3,3,3,3,2],[3,3,3,3,3,3,3,3]]": function() {
        var result = this.solver.makeComposition([[3,3,2,1],[2,2,2,2]],[[3,3,2,1],[2,2,2,2]]);
        assertEquals([[4,4,4,4,3,3,2,2],[4,4,3,3,3,3,3,2],[4,4,3,3,3,3,3,2],[3,3,3,3,3,3,3,3]], result);
    },

    "test countOfUse 1 should return [[0]]": function() {
	    var result = this.solver.countOfUse(1);
	    assertEquals(1, result.length);
	    assertEquals(1, result[0].length);
	    assertEquals(0, result[0][0]);
    },
    "test countOfUse 2 should return [[1,1]]": function() {
	    var result = this.solver.countOfUse(2);
	    assertEquals(1, result.length);
	    assertEquals(2, result[0].length);
	    assertEquals([1,1], result[0]);
    },
    "test countOfUse 3 should return [[2,2,1]]": function() {
	    var result = this.solver.countOfUse(3);
	    assertEquals(1, result.length);
	    assertEquals(3, result[0].length);
	    assertEquals([2,2,1], result[0]);
    },
    "test countOfUse 4 should return [[3,3,2,1],[2,2,2,2]]": function() {
	    var result = this.solver.countOfUse(4);
	    assertEquals(2, result.length);
	    assertEquals([3,3,2,1], result[0]);
	    assertEquals([2,2,2,2], result[1]);
    },
    "test countOfUse 5 should return [[4,4,3,2,1],[3,3,3,3,1],[3,3,2,2,2]]": function() {
	    var result = this.solver.countOfUse(5);
	    assertEquals([[4,4,3,2,1],[3,3,3,3,1],[3,3,2,2,2]], result);
    },

    "test solve [5, 8, 8] should return 34": function() {
	assertEquals(34, this.solver.solve([5, 8, 8]));
    }
});
