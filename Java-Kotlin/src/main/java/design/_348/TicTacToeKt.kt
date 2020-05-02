package design._348

class TicTacToeKt(n: Int) {

    private val rows = IntArray(n)

    private val cols = IntArray(n)

    private var diagonal = 0

    private var reverseDiagonal = 0

    private var size = n

    /** Initialize your data structure here. */


    /** Player {player} makes a move at ({row}, {col}).
    @param row The row of the board.
    @param col The column of the board.
    @param player The player, can be either 1 or 2.
    @return The current winning condition, can be either:
    0: No one wins.
    1: Player 1 wins.
    2: Player 2 wins. */
    fun move(row: Int, col: Int, player: Int): Int {
        val toAdd = if (player == 1) 1 else -1
        rows[row] += toAdd
        cols[col] += toAdd

        if (col == row) {
            diagonal += toAdd
        }

        if (col == size - row - 1) {
            reverseDiagonal += toAdd
        }

        if (Math.abs(rows[row]) == size
            || Math.abs(cols[col]) == size
            || Math.abs(diagonal) == size
            || Math.abs(reverseDiagonal) == size
        ) {
            return player
        }

        return 0
    }
}