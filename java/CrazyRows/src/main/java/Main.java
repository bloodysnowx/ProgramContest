import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Atsushi
 * Date: 2013/10/29
 * Time: 18:38
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args)
    {
        int[][] A = { { 1, 0 }, { 1, 1 } };
        int answer = solve(A);
        System.out.println(answer);

        int[][] B = { { 0, 0, 1 }, { 1, 0, 0 }, { 0, 1, 0 } };
        answer = solve(B);
        System.out.println(answer);

        int[][] C = { { 1, 1, 1, 0 }, { 1, 1, 0, 0 }, { 1, 1, 0, 0 }, { 1, 0, 0, 0 } };
        answer = solve(C);
        System.out.println(answer);
    }

    public static int solve(int[][] A)
    {
        int answer = 0;

        List<Integer> a = new ArrayList<Integer>(A.length);
        for(int[] row : A)
        {
            int max = 0;
            for(int i = 0; i < row.length; ++i)
                if(row[i] > 0) max = i + 1;
            a.add(max);
        }

        for(int i = 0; i < A.length; ++i)
        {
            for(int j = 0; j < A.length; ++j)
            {
                if(i + 1 >= a.get(j)) { answer += j; a.remove(j); break; }
            }
        }

        return answer;
    }
}
