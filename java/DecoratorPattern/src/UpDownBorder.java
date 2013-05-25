
public class UpDownBorder extends Border {
	private final char border;
	public UpDownBorder(Display display, char border) {
		super(display);
		this.border = border; 
	}

	@Override
	public int getColumns() {
		return this.display.getColumns();
	}

	@Override
	public int getRows() 
	{
		return this.display.getRows() + 2;
	}

	@Override
	public String getRowText(int row) {
		if(row == 0 || row == this.display.getRows() + 1)
		{
			return makeLine(border, getColumns());
		}
		else
		{
			return this.display.getRowText(row - 1);
		}
	}
	private String makeLine(char ch, int count) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < count; i++) {
            buf.append(ch);
        }
        return buf.toString();
    }
}
