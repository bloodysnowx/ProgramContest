package com.bloodysnow.ProgrammingContest.CalcLatticePoint;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Atsushi
 * Date: 2013/09/02
 * Time: 17:57
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
        Point a = new Point(1, 11);
        Point b = new Point(5, 3);
        // a.x <= b.x
        int commonDivisor = gcd(Math.abs(a.x - b.x), Math.abs(a.y - b.y));
        int denominator = (b.x - a.x) / commonDivisor;
        int numerator = (b.y - a.y) / commonDivisor;

        for(int i = 1; i * Math.abs(denominator) < Math.abs(a.x - b.x) ; ++i)
        {
            System.out.println(new Point(a.x + i * denominator, a.y + i * numerator));
        }
    }

    public static int gcd(int x, int y) {
        if(y == 0) return x;
        return gcd(y, x % y);
    }
}
