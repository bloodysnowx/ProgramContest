TestCase("RoadBlocksTest", {
    setUp: function() {
        this.solver = Object.create(RoadBlocksSolver);
    },
    "test solve [[0,1,100],[1,2,250],[2,3,100],[1,3,200]] should return 450": function() {
        assertEquals(450, this.solver.solve(4, [[0,1,100],[1,2,250],[2,3,100],[1,3,200]]));
    },
    "test solve [[0,1,100],[1,2,350],[2,3,100],[1,3,200]] should return 450": function() {
        assertEquals(500, this.solver.solve(4, [[0,1,100],[1,2,350],[2,3,100],[1,3,200]]));
    }

});
