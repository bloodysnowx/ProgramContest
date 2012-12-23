import java.io.IOException;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileIO f = new FileProperties();
		try {
			f.readFromFile("newfile.txt");
			f.setValue("year", "2004");
			f.setValue("month", "4");
			f.setValue("day", "21");
			f.writeToFile("newfile.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
