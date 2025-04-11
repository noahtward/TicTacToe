public class Main {
    public static void main(String[] args) {
        Board gameBoard = new Board();
        
        gameBoard.displayBoard();
        try { //tries to make move, if space is already taken that is handled;
            gameBoard.makeMove(2, 'X');
        } catch (InvalidMoveException e) {
            System.out.println(e.getMessage());
        }
        gameBoard.displayBoard();
        
        
    }
}