
/**
 * The TicTacToe program implements an application that
 * runs a tic-tac-toe game in the terminal window. The
 * game can be continuously played until the player 
 * tells the program they are done playing.
 * 
 * @author Mya Scottorn
 * @version 1.0
 * @since 2023-07-01
 */

import java.util.Scanner;
import java.util.HashSet;

public class TicTacToe {

    /**
     * Controls the main game loop and flow of the game.
     * 
     * @param args A string array containing the command
     *             line arguments.
     */
    public static void main(String[] args) {

        // Create new instance of the board
        Board board = new Board();

        // Scanner instance for reading input from the user
        Scanner scanner = new Scanner(System.in);

        // Initial playing conditions
        char player = 'O';
        boolean xTurn = false;
        boolean playing = true;
        boolean winConditionMet = false;

        // Set for determining moves made.
        // Sets are useful for checking if a value already exists.
        HashSet<Integer> moves = new HashSet<Integer>();

        // Print out to the terminal the welcome message
        System.out.println("TWelcome to Tic-Tac-Toe! Let's play! \n");

        // main game loop
        while (playing) {

            // switch turns
            xTurn = !xTurn;

            if (xTurn) {
                player = 'X';
            } else {
                player = 'O';
            }

            // display the board at the beginning of every new turn
            board.displayBoard();

            // Indicate the player turn and get input from user
            System.out.println(player + "'s Turn- \nPick an available spot: ");
            int spot = scanner.nextInt();

            // Validate user input and only update the board when valid
            while (moves.contains(spot) || spot <= 0 || spot > 9) {
                System.out.println("That was not an available spot. Please choose another: ");
                spot = scanner.nextInt();
            }
            if (!moves.contains(spot)) {
                moves.add(spot); // Utilizing HashSet specific functionality
                board.updateBoard(spot, player);
            }

            // Check for win conditions and update if the game is over
            winConditionMet = board.checkBoardForWin();
            playing = !winConditionMet && moves.size() < 9;

            // End of game
            if (!playing) {
                // Display final board
                board.displayBoard();

                // Check if there was a winner or tie and indicate on terminal
                if (winConditionMet) {
                    System.out.println(player + " WINS!");
                } else {
                    System.out.println("TIE");
                }

                // consume the newline character
                scanner.nextLine();

                // Ask user to play again and handle response
                System.out.println("Would you like to play again? (Y/N) ");
                String response = scanner.nextLine();
                if (response.toLowerCase().equals("y")) {
                    playing = true;
                    board.resetBoard();
                    moves.clear();
                } else {
                    playing = false;
                    System.out.println("Thanks for playing!");
                }
            }

        }
    }
}
