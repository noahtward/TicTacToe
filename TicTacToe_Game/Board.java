public class Board {

    private char[][] board;
    // private String[] winCombos = {
    //     ""
    // }

    private String boardToString() {
        String boardStr = "";
        for (char[] row: board) {
            for (char col : row) {
                boardStr += col;
            }
        }
        return boardStr;
    }

    //Constructor
    public Board() {
        board = new char[][] {
            {'#', '#', '#'},
            {'#', '#', '#'},
            {'#', '#', '#'}
        };
    }

    //Dispaly board and moves
    public void display() {
        for (char[] row: board) {
            for (char col : row) {
                System.out.print(col + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public void makeMove(int[] moveCoordinates, char move) {
        board[moveCoordinates[1]][moveCoordinates[0]] = move; // x,y = {'x', 'y'} = board[y][x]
    }
    public boolean checkWin(int col, int row, char move) {
        //check row
        if (board[row][0] == move &&
            board[row][1] == move &&
            board[row][2] == move) {return true;}

        //check column
        if (board[0][col] == move &&
            board[1][col] == move &&
            board[2][col] == move) {return true;}

        //check diagonals
        if (row == col) {
            if (board[0][0] == move &&
                board[1][1] == move &&
                board[2][2] == move) {return true;}
        }
        if (row + col == 2) {
            if (board[0][2] == move &&
                board[1][1] == move &&
                board[2][0] == move) {return true;}
        }
        return false;    
    }
}