
// import javax.swing.*;
import java.util.Scanner;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        Board board = new Board();

        Scanner scanner = new Scanner(System.in);

        boolean xTurn = false;
        char player = 'O';

        boolean playing = true;
        boolean winConditionMet = false;

        HashSet<Integer> moves = new HashSet<Integer>();

        System.out.println("TWelcome to Tic-Tac-Toe! Let's play! \n");

        while (playing) {
            xTurn = !xTurn;

            if (xTurn) {
                player = 'X';
            } else {
                player = 'O';
            }

            board.displayBoard();

            System.out.println(player + "'s Turn- \nPick an available spot: ");
            int spot = scanner.nextInt();
            while (moves.contains(spot) || spot <= 0 || spot > 9) {
                System.out.println("That was not an available spot. Please choose another: ");
                spot = scanner.nextInt();
            }
            if (!moves.contains(spot)) {
                moves.add(spot);
                board.updateBoard(spot, player);
            }

            winConditionMet = board.checkBoardForWin();

            playing = !winConditionMet && moves.size() < 9;

            if (!playing) {
                board.displayBoard();
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
