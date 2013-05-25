import java.util.ArrayList;
import java.util.List;


public class MultiStringDisplay extends Display {
	private List<String> strings;
	private int columnLength;
	
	public MultiStringDisplay()
	{
		strings = new ArrayList<String>();
	}
	
	public void add(String str)
	{
		strings.add(str);
		columnLength = Math.max(columnLength, str.getBytes().length);
	}
	
	@Override
	public int getColumns() {
		return columnLength;
	}

	@Override
	public int getRows() {
		return strings.size();
	}

	@Override
	public String getRowText(int row) {
		return pudding(strings.get(row));
	}

	private String pudding(String str) {
		StringBuffer buf = new StringBuffer(str);
        for (int i = 0; i < columnLength - str.getBytes().length; i++) {
            buf.append(' ');
        }
		return buf.toString();
	}
}
