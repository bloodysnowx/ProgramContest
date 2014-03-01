TestCase("InterestingPartyTest", {
    setUp: function() {
        this.solver = Object.create(Solver);
    },
    "test 10 should return [3, 9]": function() {
        assertEquals([3, 9], this.solver.solve(10));
    },  
    "test 3 should return [2]": function() {
        assertEquals([2], this.solver.solve(3));
    },  
    "test 9 should return [2, 4, 8]": function() {
        assertEquals([2, 4, 8], this.solver.solve(9));
    },  
    "test 26 should return [5, 25]": function() {
        assertEquals([5, 25], this.solver.solve(26));
    },
    "test 30 should return [29]": function() {
        assertEquals([29], this.solver.solve(30));
    }
 });
