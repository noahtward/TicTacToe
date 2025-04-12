/*
 * All int[] move's will be as [x, y]
 * 
 */


public class Board {
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
    public int boardCoordinateToNum(int[] moveCoordinate) {
        int col = moveCoordinate[0];
        int row = moveCoordinate[1];
        int moveNum = (((row + 1) * (col + 1)) - 1);

        return moveNum;
    }

    //Converts board num 0-8 into coordinates [x, y]
    public int[] boardNumToCoordinate(int move) {
        int[] moveCoordinate = new int[2];
        int row, col;

        row = move / 3;
        col = move % 3;

        moveCoordinate[0] = col;
        moveCoordinate[1] = row;

        return moveCoordinate;
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

    //Makes a move, replacing a board character with symbol
    public void makeMove(int move, char symbol) throws InvalidMoveException, ArrayIndexOutOfBoundsException {
        if (move < 0 || move > 8) {
            throw new ArrayIndexOutOfBoundsException("Invalid input: Out of bounds");
        }
        int[] moveCoordinate = boardNumToCoordinate(move);
        
        if (board[moveCoordinate[1]][moveCoordinate[0]] == '#') {
            board[moveCoordinate[1]][moveCoordinate[0]] = symbol;
        }
        else {
            throw new InvalidMoveException("Board space already taken");
        }
    }
}