package net.demo.algorithms.backtracking;

public class NQueenProblem {
    //function which checks whether the queen at given position can be attacked or not
    private static boolean isAttacked(int row, int column, int[][] chessBoard, int queens) {

        //checking in the particular row and column
        for (int i = 0; i < queens; i++) {
            //row check
            if ((chessBoard[row][i] == 1) && (i != column)) {
                return true;
            }

            //column check
            if ((chessBoard[i][column] == 1) && (i != row)) {
                return true;
            }
        }

        //diagonals check
        for (int i = 0; i < queens; i++) {
            for (int j = 0; j < queens; j++) {
                if (((i + j) == (row + column)) || ((i - j) == (row - column))) {
                    if (((i != row) || (j != column)) && (chessBoard[i][j] == 1)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean nQueens(int[][] chessBoard, int level, int queens) {
        if (level == queens) {
            return true;
        }

        for (int j = 0; j < queens; j++) {

            if (isAttacked(level, j, chessBoard, queens)) {
                continue;
            }

            chessBoard[level][j] = 1;

            if (nQueens(chessBoard, level + 1, queens)) {
                return true;
            }

            chessBoard[level][j] = 0;
        }

        return false;
    }

    private static void displayBoard(int[][] chessBoard, int N) {
        System.out.println("\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(" " + chessBoard[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\n");
    }

    public static void main(String args[]) {

        int size = 4;//s.nextInt();

        int[][] chessBoard = new int[size][size];

        if (nQueens(chessBoard, 0, size)) {
            System.out.println("Solution found!");
            displayBoard(chessBoard, size);
        } else {
            System.out.println("No solution.");
        }
    }
}