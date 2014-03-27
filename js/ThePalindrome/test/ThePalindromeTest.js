TestCase("ThePalindromeTest", {
    setUp: function() {
        this.solver = Object.create(Solver);
    },
    "test abab should return 5": function() {
        assertEquals(5, this.solver.solve("abab"));
    },  
    "test abacaba should return 7": function() {
        assertEquals(7, this.solver.solve("abacaba"));
    },  
    "test qwerty should return 11": function() {
        assertEquals(11, this.solver.solve("qwerty"));
    },  
    "test abdfhdyrbdbsdfghjkllkjhgfds should return 38": function() {
        assertEquals(38, this.solver.solve("abdfhdyrbdbsdfghjkllkjhgfds"));
    }
 });
