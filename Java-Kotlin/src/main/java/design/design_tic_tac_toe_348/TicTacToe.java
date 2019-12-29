package design.design_tic_tac_toe_348;

public class TicTacToe {

    // if row == col means in the diagonal
    private int diagonal;

    // if col = size - row - 1 in the reverse diagonal
    private int reverseDiagonal;

    private int[] rows;

    private int[] cols;

    private int size;


    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.size = n;
        this.rows = new int[n];
        this.cols = new int[n];
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int toAdd = player == 1 ? 1 : -1;

        rows[row] += toAdd;
        cols[col] += toAdd;

        if (row == col) {
            diagonal += toAdd;
        }

        if (col == size - row - 1) {
            reverseDiagonal += toAdd;
        }

        if (Math.abs(rows[row]) == size || Math.abs(cols[col]) == size
                || Math.abs(diagonal) == size || Math.abs(reverseDiagonal) == size) {
            return player;
        }

        return 0;
    }
}
