/*
 * All int[] move's will be as [x, y]
 * 
 */


public class Board {
    //TODO: Create 2d array board
    private char[][] board;

    //Constructor, initializes board
    public Board() {
        board = new char[][] {
            {'#', '#', '#'}, 
            {'#', '#', '#'},
            {'#', '#', '#'}
        };
    }

    //Coverts move coordinates [x, y] into a useable number of 0-8
    public int boardCoordinateToNum(int[] move) {
        int col = move[0];
        int row = move[1];
        int moveNum = (((row + 1) * (col + 1)) - 1);

        return moveNum;
    }

    //Converts board num 0-8 into coordinates [x, y]
    public int[] boardNumToCoordinate(int move) {
        int[] coordinate = new int[2];
        int row, col;

        row = move / 3;
        col = move % 3;

        coordinate[0] = col;
        coordinate[1] = row;

        return coordinate;
    }

    //Displays board in a tic-tac-toe format:
    public void displayBoard() {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}