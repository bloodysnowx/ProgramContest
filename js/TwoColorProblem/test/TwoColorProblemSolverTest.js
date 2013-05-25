TestCase("TwoColorProblemSolverTest", {
    setUp: function() {
        this.solver = Object.create(TwoColorProblemSolver);
    },
    "test [[0,1]] should return true": function() {
        assertEquals(true, this.solver.solve([[0,1]]));
    },
    "test [[0,1],[1,2],[2,0]] should return false": function() {
        assertEquals(false, this.solver.solve([[0,1],[1,2],[2,0]]));
    }
});
