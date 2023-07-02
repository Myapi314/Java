public class Board {
    char[] board = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };

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

    public void updateBoard(int spot, char player) {
        board[spot - 1] = player;
    }

    public void resetBoard() {
        for (int i = 0; i < board.length; i++) {
            board[i] = (char) ('1' + i);
        }
    }

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
