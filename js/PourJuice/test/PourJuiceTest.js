TestCase("PourJuiceTest", {
    setUp: function() {
        this.solver = Object.create(Solver);
    },

    "test ([20, 20], [5, 8], [0], [1]) should return [0, 13]": function() {
        assertEquals([0, 13], this.solver.solve([20, 20], [5, 8], [0], [1]));
    },  
    "test ([10, 10], [5, 8], [0], [1]) should return [3, 10]": function() {
        assertEquals([3, 10], this.solver.solve([10, 10], [5, 8], [0], [1]));
    },  
    "test ([14, 35, 86, 58, 25, 62], [6, 34, 27, 38, 9, 60], [1, 2, 4, 5, 3, 3, 1, 0], [0, 1, 2, 4, 2, 5, 3, 1]) should return [0, 14, 65, 35, 25, 35]": function() {
        assertEquals([0, 14, 65, 35, 25, 35], this.solver.solve([14, 35, 86, 58, 25, 62], [6, 34, 27, 38, 9, 60], [1, 2, 4, 5, 3, 3, 1, 0], [0, 1, 2, 4, 2, 5, 3, 1]));
    },  
    "test ([700000, 800000, 900000, 1000000], [478478, 478478, 478478, 478478], [2, 3, 2, 0, 1], [0, 1, 1, 3, 2]) should return [0, 156956, 900000, 856956]": function() {
        assertEquals([0, 156956, 900000, 856956], this.solver.solve([700000, 800000, 900000, 1000000], [478478, 478478, 478478, 478478], [2, 3, 2, 0, 1], [0, 1, 1, 3, 2]));
    }
 });
