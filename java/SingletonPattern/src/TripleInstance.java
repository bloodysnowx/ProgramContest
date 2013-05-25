
public enum TripleInstance {
	ONE, TWO, THREE;
	public TripleInstance getInstance(int id) {
		return TripleInstance.values()[id];
	}
}
