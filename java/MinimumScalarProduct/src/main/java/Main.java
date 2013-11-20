import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Atsushi
 * Date: 2013/10/29
 * Time: 17:11
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
        Integer[] a = { 1, 3, -5 };
        Integer[] b = { -2, 4, 1 };
        int answer = solve(a, b);
        System.out.println(answer);

        Integer[] x = { 1, 2, 3, 4, 5 };
        Integer[] y = { 1, 0, 1, 0, 1 };
        answer = solve(x, y);
        System.out.println(answer);

        Integer[] v = { 1, 2, 3, 4, 5, 2, 3, 4, 5, 2, 3, 4, 5, 2, 3, 4, 5, 2, 3, 4, 5, 2, 3, 4, 5, 2, 3, 4, 5, 2, 3, 4, 5, 2, 3, 4, 5, 2, 3, 4, 5, 2, 3, 4, 5, 2, 3, 4, 5, 2, 3, 4, 5, 2, 3, 4, 5, 2, 3, 4, 5 };
        Integer[] w = { 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 };
        answer = solve(v, w);
        System.out.println(answer);


    }

    public static int solve(Integer[] a, Integer[] b)
    {
        Arrays.sort(a);
        Arrays.sort(b);
        List<Integer> b_list = Arrays.asList(b);
        Collections.reverse(b_list);

        int answer = 0;

        Iterator<Integer> b_iterator = b_list.iterator();
        int i = 0;
        while(b_iterator.hasNext())
            answer += a[i++] * b_iterator.next();

        return answer;
    }
}
