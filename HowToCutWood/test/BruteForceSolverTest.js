TestCase("BruteForceSolverTest", {
    setUp: function() {
	this.solver = Object.create(BruteForceSolver);
    },
    "test countOfUse 1 should return [[0]]": function() {
	var result = this.solver.countOfUse(1);
	assertEquals(1, result.length);
	assertEquals(1, result[0].length);
	assertEquals(0, result[0][0]);
    },
    "test solve [5, 8, 8] should return 34": function() {
	assertEquals(34, this.solver.solve([5, 8, 8]));
    }
});
