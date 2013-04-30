TestCase("BinarySearcherTest", {
    setUp: function() {
        this.searcher = Object.create(BinarySearcher);
    },

    "test solve 1 from [1] should return 0": function() {
	assertEquals(0, this.searcher.search(1, [1]));
    },
    "test solve 1 from [1, 3, 5, 7, 9] should return 0": function() {
	assertEquals(0, this.searcher.search(1, [1, 3, 5, 7, 9]));
    },
    "test solve 9 from [1, 3, 5, 7, 9] should return 4": function() {
	assertEquals(4, this.searcher.search(9, [1, 3, 5, 7, 9]));
    },
    "test solve 0 from [1, 3, 5, 7, 9] should return -1": function() {
	assertEquals(-1, this.searcher.search(0, [1, 3, 5, 7, 9]));
    }
});
