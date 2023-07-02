/**
 * Class to handle board operations for TicTacToe.
 * 
 * @author Mya Scottorn
 */

public class Board {

    char[] board = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };

    /**
     * Prints out the spaces of the board to look
     * like a traditional tic-tac-toe board.
     */
    public void displayBoard() {
        for (int i = 0; i < board.length; i++) {
            System.out.print(board[i]);
            if (i != board.length - 1) {
                if ((i + 1) % 3 == 0) {
                    System.out.println("\n-----");
                } else {
                    System.out.print("|");
                }
            } else {
                System.out.println("\n");
            }

        }
    }

    /**
     * Updates the board with the player taking the spot of the
     * number in the array.
     * 
     * @param spot   The spot to be updated
     * @param player The player to replace the num char with.
     */
    public void updateBoard(int spot, char player) {
        board[spot - 1] = player;
    }

    /**
     * Resets the board to be an array of chars from
     * 1-9.
     */
    public void resetBoard() {
        for (int i = 0; i < board.length; i++) {
            board[i] = (char) ('1' + i);
        }
    }

    /**
     * Checks the board for any of the specified win conditions.
     * 
     * @return Boolean true if a win condition has been met
     */
    public boolean checkBoardForWin() {
        boolean winCondition = false;

        // Win conditions
        boolean[] winConditions = { (board[0] == board[4]) && (board[0] == board[8]), // right diagonal
                (board[2] == board[4]) && (board[2] == board[6]), // left diagonal
                (board[0] == board[1]) && (board[0] == board[2]), // top row
                (board[3] == board[4]) && (board[3] == board[5]), // middle row
                (board[6] == board[7]) && (board[6] == board[8]), // bottom row
                (board[0] == board[3]) && (board[0] == board[6]), // first column
                (board[1] == board[4]) && (board[1] == board[7]), // second column
                (board[2] == board[5]) && (board[2] == board[8]) // third column
        };

        for (boolean win : winConditions) {
            if (win)
                return win;
        }

        return winCondition;
    }
}
