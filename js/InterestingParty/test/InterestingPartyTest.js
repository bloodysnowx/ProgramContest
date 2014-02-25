TestCase("InterestingPartyTest", {
    setUp: function() {
        this.solver = Object.create(Solver);
    },
    "test Example0 should return 4": function() {
        assertEquals(4, this.solver.solve(['fishing', 'gardening', 'swimming', 'fishing'], ['hunting', 'fishing', 'fishing', 'biting']));
    },  
    "test Example1 should return 1": function() {
        assertEquals(1, this.solver.solve(['variety', 'diversity', 'loquacity', 'courtesy'], ['talking', 'speaking', 'discussion', 'meeting']));
    },  
    "test Example2 should return 3": function() {
        assertEquals(3, this.solver.solve(['snakes', 'programming', 'cobra', 'monty'], ['python', 'python', 'anaconda', 'python']));
    },  
    "test Example3 should return 6": function() {
        assertEquals(6, this.solver.solve(['t', 'o', 'p', 'c', 'o', 'd', 'e', 'r', 's', 'i', 'n', 'g', 'l', 'e', 'r', 'o', 'u', 'n', 'd', 'm', 'a', 't', 'c', 'h', 'f', 'o', 'u', 'r', 'n', 'i'], ['n', 'e', 'f', 'o', 'u', 'r', 'j', 'a', 'n', 'u', 'a', 'r', 'y', 't', 'w', 'e', 'n', 't', 'y', 't', 'w', 'o', 's', 'a', 't', 'u', 'r', 'd', 'a', 'y']));
    }
 });
