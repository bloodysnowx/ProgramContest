import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;


public class FileProperties implements FileIO {
	public FileProperties() {
		super();
		prop = new Properties();
	}

	private Properties prop;
	private InputStream in;
	private OutputStream out;

	@Override
	public void readFromFile(String filename) throws IOException {
		in = new FileInputStream(filename);		
		prop.load(in);
	}

	@Override
	public void writeToFile(String filename) throws IOException {
		out = new FileOutputStream(filename);
		prop.store(out, "comment");
	}

	@Override
	public void setValue(String key, String value) {
		prop.setProperty(key, value);
	}

	@Override
	public String getValue(String key) {
		return prop.getProperty(key);
	}
}
