package org.practice.dsa.recursion.backtracking;

import java.util.ArrayList;

public class MazeProblem {
    public static void main(String[] args) {
        System.out.println(countWays(3, 3));
        pathPrint("", 3, 3);
        System.out.println(pathReturn("", 3, 3));
        System.out.println(pathReturnDiagonal("", 4,4));

        boolean[][] board = {
                {true, true, true},
                {true, false, true},
                {true, true, true}
        };

        pathPrintWithRestrictions("", board, 0, 0);
    }

    static int countWays(int r, int c) {
        if (r == 1 || c == 1) {
            return 1;
        }

        int left = countWays(r-1, c);
        int right = countWays(r, c-1);

        return left + right;
    }

    static void pathPrint(String p, int r, int c) {
        if (r == 1 && c == 1) {
            System.out.println(p);
            return;
        }

        if (r > 1) {
            pathPrint(p+'D', r-1, c);
        }

        if (c > 1) {
            pathPrint(p+'R', r, c-1);
        }
    }

    static ArrayList<String> pathReturn(String p, int r, int c) {
        if (r == 1 && c == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        if (r > 1) {
            ans.addAll(pathReturn(p + 'D', r-1, c));
        }
        if (c > 1) {
            ans.addAll(pathReturn(p+ 'R', r, c-1));
        }
        return ans;
    }

    static ArrayList<String> pathReturnDiagonal(String p, int r, int c) {
        if (r == 1 && c == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> ans = new ArrayList<>();

        if (r > 1 && c > 1) {
            ans.addAll(pathReturnDiagonal(p + "D", r-1, c-1));
        }
        if (r > 1) {
            ans.addAll(pathReturnDiagonal(p + "V", r-1, c));
        }
        if (c > 1) {
            ans.addAll(pathReturnDiagonal(p + "H", r, c-1));
        }
        return ans;
    }

    static void pathPrintWithRestrictions(String p, boolean[][] maze, int r, int c) {
        if (r == maze.length - 1  && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        if (r < maze.length - 1) {
            pathPrintWithRestrictions(p+'D', maze, r+1, c);
        }

        if (c < maze[0].length - 1) {
            pathPrintWithRestrictions(p+'R', maze, r, c+1);
        }
    }
}
