import java.io.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        if(args.length < 3 || !(args[0].equals("-c") || args[0].equals("-d"))) {
            System.out.println("usage [-c | -d] source target");
            System.out.println("-c compress");
            System.out.println("-d decompress");
            System.exit(1);
        }

        File sourceFile = new File(args[1]);
        File targetFile = new File(args[2]);
        try {
            FileReader sourceFileReader = new FileReader(sourceFile);
            BufferedReader bufferedReader = new BufferedReader(sourceFileReader);
            String sourceString = bufferedReader.readLine();
            bufferedReader.close();
            sourceFileReader.close();
            System.out.println(sourceString);

            Coding coding = new HuffmanCoding();
            String targetString = args[0].equals("-c") ? coding.compress(sourceString) : coding.deCompress(sourceString);
            System.out.println(targetString);

            FileWriter targetFileWriter = new FileWriter(targetFile);
            BufferedWriter bufferedWriter = new BufferedWriter(targetFileWriter);
            bufferedWriter.write(targetString);
            bufferedWriter.close();
            targetFileWriter.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
	}

}
