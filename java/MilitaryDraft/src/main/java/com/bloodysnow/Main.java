package com.bloodysnow;

/**
 * Created with IntelliJ IDEA.
 * User: Atsushi
 * Date: 2013/07/05
 * Time: 9:54
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String... args)
    {
        int[][] edges = { {4, 3, 6831}, {1, 3, 4583}, {0, 0, 6592}, {0, 1, 3063}, {3, 3, 4975}, {1, 3, 2049}, {4, 2, 2104}, {2, 2, 781} };
        MilitaryDraftSolver solver = new MilitaryDraftSolver(edges, 5, 5);
        System.out.println(solver.solve());
    }
}
