import java.util.BitSet;

/**
 * Created with IntelliJ IDEA.
 * User: Atsushi
 * Date: 2013/10/07
 * Time: 18:29
 * To change this template use File | Settings | File Templates.
 */
public class PrimeJudge {
    public static void main(String[] args)
    {
        solve(25);
        solve(53);
        solve(295927);
        solve(599144041);
    }

    static BitSet bitSet = new BitSet(32);

    public static boolean solve(int number)
    {
        boolean result = true;
        int end = (int)Math.sqrt(number);
        if(number % 2 == 0)
        {
            result = false;
            System.out.println(number + " is not prime. ( " + 2 + " * " + number / 2 + " )");
        }
        else
        {
            for(int i = 3;i <= end; i += 2)
            {
                if(number % i == 0)
                {
                    result = false;
                    System.out.println(number + " is not prime. ( " + i + " * " + number / i + " )");
                    break;
                }
            }
        }

        if(result) System.out.println(number + " is prime");
        return result;
    }

    public static boolean solve2(int number)
    {
        return true;
    }
}
