TestCase("HowToCutSolverTest", {
    setUp: function() {
	    // this.solver = Object.create(BruteForceSolver);
        this.solver = Object.create(GreedySolver);
    },

    "test solve [5, 8, 8] should return 34": function() {
	assertEquals(34, this.solver.solve([5, 8, 8]));
    },
    "test solve [4, 4, 4, 4] should return 32": function() {
	assertEquals(32, this.solver.solve([4, 4, 4, 4]));
    },
    "test solve [4, 4, 4, 8] should return 40": function() {
	assertEquals(40, this.solver.solve([4, 4, 4, 8]));
    },
    "test solve [4, 8, 12] should return 36": function() {
	assertEquals(36, this.solver.solve([4, 8, 12]));
    },
    "test solve [4, 4, 4, 12] should return 44": function() {
	assertEquals(44, this.solver.solve([4, 4, 4, 12]));
    },
    "test solve [4, 4, 8, 12] should return 28+16+8": function() {
	assertEquals(28+16+8, this.solver.solve([4, 4, 8, 12]));
    },
    "test solve [1, 1, 1, 1, 1, 1, 1, 1, 1, 1] should return 34": function() {
	assertEquals(34, this.solver.solve([1, 1, 1, 1, 1, 1, 1, 1, 1, 1]));
    },
    "test solve Array.apply(null, new Array(10000)).map(Number.prototype.valueOf, 1) should return 133616": function() {
        assertEquals(133616, this.solver.solve(Array.apply(null, new Array(10000)).map(Number.prototype.valueOf, 1)));
    }
});
