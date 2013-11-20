import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: Atsushi
 * Date: 2013/11/19
 * Time: 8:54
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args)
    {
        int length = 20;
        int[] people = {3, 6, 14};
        int answer = solve(length, people);
        System.out.println(answer);
        try
        {
            solveFromGCJ("/Users/Atsushi/github/ProgramContest/java/BribeThePrisoners/C-small-practice.in", "/Users/Atsushi/github/ProgramContest/java/BribeThePrisoners/C-small-practice.out");
            solveFromGCJ("/Users/Atsushi/github/ProgramContest/java/BribeThePrisoners/C-large-practice.in", "/Users/Atsushi/github/ProgramContest/java/BribeThePrisoners/C-large-practice.out");
        }
        catch(IOException e) { }
        finally { }
    }

    public static void solveFromGCJ(String inFilePath, String outFilePath) throws IOException {
        FileReader in = new FileReader(inFilePath);
        BufferedReader br = new BufferedReader(in);
        File file = new File(outFilePath);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        String line = br.readLine();
        int question_num = Integer.parseInt(line);
        for(int i = 0; i < question_num; ++i)
        {
            line = br.readLine();
            int length = Integer.parseInt(line.split(" ")[0]);
            line = br.readLine();
            String[] people_str = line.split(" ");
            int[] people = new int[people_str.length];
            for(int j = 0; j < people_str.length; ++j)
            {
                people[j] = Integer.parseInt(people_str[j]);
            }
            int answer = solve(length, people);
            System.out.println(answer);
            pw.println("Case #" + (i + 1) + ": " + answer);
        }
        br.close();
        in.close();
        pw.close();
    }

    public static int solve(int length, int[] people)
    {
        int new_people_len = people.length + 2;
        int[] new_people = new int[new_people_len];
        new_people[0] = 0;
        for(int i = 0; i < new_people_len - 2; ++i)
            new_people[i + 1] = people[i];
        new_people[new_people_len - 1] = length + 1;

        int[][] dp = new int[new_people_len][new_people_len];

        for(int width = 2; width < new_people_len; ++width)
        {
            for(int i = 0; i + width < new_people_len; ++i)
            {
                int min_coin = Integer.MAX_VALUE;
                for(int j = i + 1; j < i + width; ++j)
                {
                    min_coin = Math.min(dp[i][j] + dp[j][i + width], min_coin);
                }
                dp[i][i + width] = new_people[i + width] - new_people[i] - 2 + min_coin;
            }
        }

        return dp[0][new_people_len - 1];
    }
}
