/**
 * Created with IntelliJ IDEA.
 * User: Atsushi
 * Date: 2013/09/24
 * Time: 17:33
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args)
    {
        /*
         ax + by = 1 となる格子点(x, y)を求める
         y = - ( a / b ) * x + 1 / b
           = ( 1 - ax ) / b
         ( 1 - ax ) が b の整数倍であれば OK

         ax + by = 1 となる整数の組(x, y)が存在する(a, b)は互いに素

         〜簡単な説明〜
         a, bの最大公約数をkとして、a = k * c, b = k * dと表せるので、
         ax + by = k(cx + dy)となり、kの倍数になってしまう。
         よって、k = 1(つまり、互いに素)でないと、ax + by = 1とはならない。
        */

        int a = 4;
        int b = 11;
        solve(a, b);

        a = 831078519;
        b = 384172;
        solve(a, b);

        a = 485289232;
        b = 883123222;
        solve(a, b);
    }

    static int a_count = 0;
    static int b_count = 0;
    static int now = 0;

    public static void solve(int a, int b)
    {
        if(gcd(a, b) != 1)
        {
            System.out.println(-1);
        }
        else
        {
            a_count = 0;
            b_count = 0;
            now = 0;
            while(now != 1)
            {
                /*
                if(now < 1) while(now < 1) { now += a; a_count++; }
                else if(now > 1) while(now > 1) { now -= a; a_count--; }

                if(now < 1) while(now < 1) { now += b; b_count++; }
                else if(now > 1) while(now > 1) { now -= b; b_count--; }
                */
                a_count += go(a);
                b_count += go(b);
            }

            System.out.println(a_count + ", " + b_count);
        }
    }

    public static int go(int value)
    {
        int count = 0;
        int more = 0;
        if(now < 1) {
            count = (1 - now) / value;
            more = ((1 - now) % value) == 0 ? 0 : 1;
        }
        else if(now > 1) {
            count = -((now - 1) / value);
            more = ((now - 1) % value) == 0 ? 0 : -1;
        }
        count += more;
        now += count * value;
        return count;
    }

    public static int gcd(int x, int y)
    {
        if(y == 0) return x;
        return gcd(y, x % y);
    }
}
