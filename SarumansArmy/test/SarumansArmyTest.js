TestCase("SarumansArmyTest", {
    setUp: function() {
        this.solver = Object.create(Solver);
    },

    "test ({1}, 1) should return 1": function() {
        var points = new Array(1);
        points[0] = 1;
        var R = 1;
        assertEquals(1, this.solver.solve(points, R));
    },  
 
    "test ({1, 3}, 1) should return 2": function() {
        var points = new Array(2);
        points[0] = 1;
        points[1] = 3;
        var R = 1;
        assertEquals(2, this.solver.solve(points, R));
    }
});
