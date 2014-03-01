TestCase("InterestingPartyTest", {
    setUp: function() {
        this.solver = Object.create(Solver);
    },
    "test [1, 2, 3] should return 12": function() {
        assertEquals(12, this.solver.solve([1, 2, 3]));
    },  
    "test [1, 3, 2, 1, 1, 3] should return 36": function() {
        assertEquals(36, this.solver.solve([1, 3, 2, 1, 1, 3]));
    },  
    "test [1000, 999, 998, 997, 996, 995] should return 986074810223904000": function() {
        assertEquals(986074810223904000, this.solver.solve([1000, 999, 998, 997, 996, 995]));
    },  
    "test [1, 1, 1, 1] should return 2": function() {
        assertEquals(2, this.solver.solve([1, 1, 1, 1]));
    }
 });
