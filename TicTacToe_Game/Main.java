import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Board gameBoard = new Board();
        int[] moveCoordinates = new int[2];
        char move = 'X';

        //Game loop:
        while (true) { 
            gameBoard.display();
            moveCoordinates = playerMove(input); // returns {x, y}
            move = 'X';
            gameBoard.makeMove(moveCoordinates, move);
            if (gameBoard.checkWin(moveCoordinates[0], moveCoordinates[1], move)) {
                System.out.println("Player wins!");
                break;
            }
            moveCoordinates = computerMove();
            move = 'O';
            gameBoard.makeMove(moveCoordinates, move);
            if (gameBoard.checkWin(moveCoordinates[0], moveCoordinates[1], move)) {
                System.out.println("Computer wins!");
                break;
            }
            System.out.println();
        }
    }
    public static int[] playerMove(Scanner input) {
        System.out.print("Make your move (x, y) >> ");
        int col = input.nextInt() - 1;
        int row = input.nextInt() -1 ;
        int[] coordinates = {col, row};
        return coordinates;
    }
    public static int[] computerMove() {
        Random random = new Random();
        int col = random.nextInt(3);
        int row = random.nextInt(3);
        int[] coordinates = {col, row};
        System.out.println("Computer made move: (" + (col + 1) + ", " + (row + 1) + ")");
        return coordinates;
    }
}