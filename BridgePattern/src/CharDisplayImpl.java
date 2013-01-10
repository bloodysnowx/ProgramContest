
public class CharDisplayImpl extends DisplayImpl {
	public CharDisplayImpl(char start, char main, char end) {
		super();
		this.start = start;
		this.main = main;
		this.end = end;
	}

	private final char start;
	private final char main;
	private final char end;
	
	@Override
	public void rawOpen() {
		System.out.print(start);		
	}

	@Override
	public void rawPrint() {
		System.out.print(main);
	}

	@Override
	public void rawClose() {
		System.out.println(end);
	}

}
