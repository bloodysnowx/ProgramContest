
public class QuickSorter implements Sorter {
	private Comparable[] data;
	@Override
	public void sort(Comparable[] data) {
		this.data = data;
		qsort(0, data.length - 1);
	}
	
	private void qsort(int start, int end)
	{
		int saved_start = start;
		int saved_end = end;
		Comparable mid = data[(start + end) / 2];
		
		do {
			while(data[start].compareTo(mid) < 0) ++start;
			while(mid.compareTo(data[end]) < 0) --end;
			if(start <= end)
			{
				Comparable tmp = data[start];
				data[start++] = data[end];
				data[end--] = tmp;
			}
		} while (start <= end);
		
		if(saved_start < end) qsort(saved_start, end);
		if(start < saved_end) qsort(start, saved_end);
	}
}
