SarumansArmyTest = TestCase("SarumansArmyTest");
 
SarumansArmyTest.prototype.testSolve = function(){
    var solver = new SarumansArmy.Solver();
    assertEquals("Hello World!", solver.solve("World"));
};
