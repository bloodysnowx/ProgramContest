TestCase("SarumansArmyTest", {
    setUp: function() {
        this.solver = Object.create(Solver);
    },

    "test ({1}, 1) should return 1": function() {
        var points = [1];
        var R = 1;
        assertEquals(1, this.solver.solve(points, R));
    },  
 
    "test ({1, 3}, 1) should return 2": function() {
        var points = [1, 3];
        var R = 1;
        assertEquals(2, this.solver.solve(points, R));
    },

    "test ({1, 3, 5}, 2) should return 1": function() {
        var points = [1, 3, 5];
        var R = 2;
        assertEquals(1, this.solver.solve(points, R));
    },

    "test ({1, 2, 3, 4, 5, 6}, 1) should return 2": function() {
        var points = [1, 2, 3, 4, 5, 6];
        var R = 2;
        assertEquals(2, this.solver.solve(points, R));
    },

    "test ({1, 2, 4, 5, 6, 7}, 1) should return 3": function() {
        var points = [1, 2, 4, 5, 6, 7];
        var R = 1;
        assertEquals(3, this.solver.solve(points, R));
    },

    "test ({1, 2, 3, 4, 7, 10, 15, 16, 17, 18}, 3) should return 3": function() {
        var points = [1, 2, 3, 4, 7, 10, 15, 16, 17, 18];
        var R = 3;
        assertEquals(3, this.solver.solve(points, R));
    }
});
