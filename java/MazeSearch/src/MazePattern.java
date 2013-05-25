public enum MazePattern {
	START("S"), PASS("."), WALL("#"), GOAL("G");

	@Override
	public String toString() {
		return this.code;
	}

	private String code;

	MazePattern(String c) {
		code = c;
	}

}
