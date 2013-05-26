import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileDisplayImpl extends DisplayImpl {
	public FileDisplayImpl(String path) {
		super();
		this.path = path;
	}

	String path;
	FileReader fr;
	BufferedReader br;

	@Override
	public void rawOpen() {
		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void rawPrint() {
		String line;
        try {
			while ((line = br.readLine()) != null) {
			    System.out.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void rawClose() {
		try {
			br.close();
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
