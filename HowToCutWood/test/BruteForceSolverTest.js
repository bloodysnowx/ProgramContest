TestCase("BruteForceSolverTest", {
    setUp: function() {
	this.solver = Object.create(BruteForceSolver);
    },
    "test [5, 8, 8] should return 34": function() {
	assertEquals(34, this.solver.solve([5, 8, 8]));
    }
});
