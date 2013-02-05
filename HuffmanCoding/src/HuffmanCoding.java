import java.util.Dictionary;
import java.util.Hashtable;


public class HuffmanCoding implements Coding {

	@Override
	public byte[] compress(byte[] src) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] deCompress(byte[] src) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String compress(String src) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deCompress(String src) {
		String[] tmp = src.split(";");
		String[] dictTmp = tmp[0].split(",");
		String code = tmp[1];
		Dictionary<String, String> dict = new Hashtable<String, String>();
		for(String str : dictTmp)
		{
			tmp = str.split("=");
			dict.put(tmp[1], tmp[0]);
		}
		StringBuilder result = new StringBuilder();
		StringBuilder buffer = new StringBuilder();
		
		for(int i = 0; i < code.length(); ++i)
		{
			buffer.append(code.charAt(i));
			String str = dict.get(buffer.toString());
			if(str != null)
			{
				result.append(str);
				buffer = new StringBuilder();
			}
		}
		
		return result.toString();
	}

}
