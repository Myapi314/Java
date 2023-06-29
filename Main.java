
// import javax.swing.*;
import java.util.Scanner;
import java.util.HashSet;

public class Main {

    static void displayBoard(char[] board) {
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

    static boolean checkWin(char[] board) {
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

    public static void main(String[] args) {
        // JFrame frame = new JFrame("My First GUI", null);
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setSize(300, 300);

        // JButton button = new JButton("Press");
        // frame.getContentPane().add(button);
        // frame.setVisible(true);

        Scanner scanner = new Scanner(System.in);

        boolean xTurn = false;
        char player = 'O';

        boolean playing = true;
        boolean winConditionMet = false;

        char[] board = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        HashSet<Integer> moves = new HashSet<Integer>();

        System.out.println("TWelcome to Tic-Tac-Toe! Let's play! \n");

        while (playing) {
            xTurn = !xTurn;

            if (xTurn) {
                player = 'X';
            } else {
                player = 'O';
            }

            displayBoard(board);

            System.out.println(player + "'s Turn- \nPick an available spot: ");
            int spot = scanner.nextInt();
            while (moves.contains(spot) || spot <= 0 || spot > 9) {
                System.out.println("That was not an available spot. Please choose another: ");
                spot = scanner.nextInt();
            }
            if (!moves.contains(spot)) {
                moves.add(spot);
                board[spot - 1] = player;
            }

            winConditionMet = checkWin(board);

            playing = !winConditionMet && moves.size() < 9;

            if (!playing) {
                displayBoard(board);
                if (winConditionMet) {
                    System.out.println(player + " WINS!");
                } else {
                    System.out.println("TIE");
                }

                scanner.nextLine();
                System.out.println("Would you like to play again? (Y/N) ");
                String response = scanner.nextLine();
                if (response.toLowerCase().equals("y")) {
                    playing = true;
                    for (int i = 0; i < board.length; i++) {
                        board[i] = (char) ('1' + i);
                    }
                    moves.clear();
                } else {
                    playing = false;
                    System.out.println("Thanks for playing!");
                }
            }

        }
    }
}
