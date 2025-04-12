import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner input =  new Scanner(System.in);
        Random random = new Random();
        Board gameBoard = new Board();
        
        while (true) {
            gameBoard.displayBoard();
            newLine(1);
            playerMove(input, gameBoard);
            gameBoard.displayBoard();
            newLine(1);
            computerMove(random, gameBoard);
        }
        
        // input.close(); //Close scanner
    }

    //Gets and makes player's move
    public static void playerMove(Scanner scanner, Board board) {
        int move;
        char symbol = 'X';

        while (true) {
            try { //tries to make move, if space is already taken that is handled;
                System.out.print("Enter number 1-9 >> ");
                move = scanner.nextInt() - 1; // -1 fixes input to be within array bounds
                board.makeMove(move, symbol);
                break;
            } 
            catch (InvalidMoveException | ArrayIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid input");
                scanner.nextLine();
            }
        }
    }

    public static void computerMove(Random random, Board board) {
        int move = random.nextInt(9); //Gets random input 0-8 for the computers move, should change later to not be random
        char symbol = 'O';

        try {
            board.makeMove(move, symbol);
            System.out.println("Computer made move " + (move + 1));
        }
        catch (Exception e) {
            System.out.println("Computer error");
        }
    }

    public static void newLine(int num) {
        for (int i = 0; i < num; i++) {
            System.out.println();
        }
    }
}