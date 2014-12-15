package com.bloodysnow.ProgrammingContest.CowLayout;

/**
 * Created with IntelliJ IDEA.
 * User: Atsushi
 * Date: 2013/07/29
 * Time: 8:58
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static String createX(int i)
    {
        return "x_" + i;
    }

    public static String createComparative(int[] x, String compare)
    {
        return createX(x[0]) + " + " + x[2] + compare + createX(x[1]) + ", ";
    }

    public static String createMathematicaString(int N, int ML, int MD, int[][] likes, int[][] dislikes)
    {
        StringBuffer stringBuffer = new StringBuffer("solve[{x_1 = 0, ");
        for(int i = 1; i < N; )
            stringBuffer.append(createX(i) + " <= " + createX(++i) + ", ");
        for(int i = 0; i < ML; ++i)
            stringBuffer.append(createComparative(likes[i], " >= "));
        for(int i = 0; i < MD; ++i)
            stringBuffer.append(createComparative(dislikes[i], " <= "));
        for(int i = 1; i < N + 1; ++i)
            stringBuffer.append(createX(i) + (i < N ? ", " : "}]"));
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        int likes[][] = { { 1, 3, 10 }, { 2, 4, 20 } };
        int dislikes[][] = { { 2, 3, 3 } };
        System.out.println(createMathematicaString(4, 2, 1, likes, dislikes));
        // solve[{a <= b, b <= c, c <= d, a + 10 >= c, b + 20 >= d, b + 3 <= c}, {a,b,c,d}]
    }
}
