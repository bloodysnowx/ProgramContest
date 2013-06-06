TestCase("RoadBlocksTest", {
    setUp: function() {
        this.solver = Object.create(RoadBlocksSolver);
    },
    "test [[0,1,100],[1,2,250],[2,3,100],[1,3,200]] should return 450": function() {
        assertEquals(450, this.solver.solve([[0,1,100],[1,2,250],[2,3,100],[1,3,200]]));
    }
});
