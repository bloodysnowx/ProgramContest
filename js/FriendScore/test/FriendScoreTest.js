TestCase("FriendScoreTest", {
    setUp: function() {
        this.solver = Object.create(Solver);
    },
    "test Example 0 should return 0": function() {
        assertEquals(0, this.solver.solve(["NNN", "NNN", "NNN"]));
    },  
    "test Example 1 should return 2": function() {
        assertEquals(2, this.solver.solve(["NYY", "YNY", "YYN"]));
    },  
    "test Example 2 should return 4": function() {
        assertEquals(4, this.solver.solve(["NYNNN", "YNYNN", "NYNYN", "NNYNY", "NNNYN"]));
    },  
    "test Example 3 should return 8": function() {
        assertEquals(8, this.solver.solve(["NNNNYNNNNN", "NNNNYNYYNN", "NNNYYYNNNN", "NNYNNNNNNN",
                                           "YYYNNNNNNY", "NNYNNNNNYN", "NYNNNNNYNN", "NYNNNNYNNN",
                                           "NNNNNYNNNN", "NNNNYNNNNN"]));
    },
    "test Example 4 should return 6": function() {
        assertEquals(6, this.solver.solve(["NNNNNNNNNNNNNNY", "NNNNNNNNNNNNNNN", "NNNNNNNYNNNNNNN",
                                           "NNNNNNNYNNNNNNY", "NNNNNNNNNNNNNNY", "NNNNNNNNYNNNNNN",
                                           "NNNNNNNNNNNNNNN", "NNYYNNNNNNNNNNN", "NNNNNYNNNNNYNNN",
                                           "NNNNNNNNNNNNNNY", "NNNNNNNNNNNNNNN", "NNNNNNNNYNNNNNN",
                                           "NNNNNNNNNNNNNNN", "NNNNNNNNNNNNNNN", "YNNYYNNNNYNNNNN"]));
    }

 });
