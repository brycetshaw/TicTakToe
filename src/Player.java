import java.util.Scanner;

abstract class Player {
    protected String name;
    protected Board board;
    protected Player opponent;
    protected char mark;

    /**
     * Constructor for Player
     * @param name user input name
     * @param letterX marker (X or O)
     */
    public Player(String name, char letterX) {
        this.name = name;
        this.mark = letterX;
    }

    /**
     * aggregated the board to player
     * @param theBoard
     */
    public void setBoard(Board theBoard) {
        this.board = theBoard;
    }

    /**
     * Ends game if the game is over, else player is prompted to move, board is displayed, opponent is called.
     */
    public void play(){
        if (!(board.xWins() || board.oWins() || board.isFull())) {
            this.makeMove();
            System.out.println(opponent.mark + " Player: " + opponent.name + " plays");
            board.display();
            this.opponent.play();
            } else{
            concedeGame(selectWinner());
        }
    }

    abstract void makeMove();


    /**
     * Associates player to opponent
     * @param opponent
     */
    public void setOpponent(Player opponent){
        this.opponent = opponent;
    }

    /**
     * Identifies the winner of the game.
     * @return game winner
     */
    public Player selectWinner() {
        if(!(board.xWins() || board.oWins())){
            return null;
        }
//        if (((this.mark == Constants.LETTER_X) && board.xWins()) ||
//                ((this.mark == Constants.LETTER_O) && board.oWins())){
//            return this;
//        }
        return this.opponent;
    }

    /**
     * Outputs a game over message
     * @param winner winner of the game (player or null)
     */
    public void concedeGame(Player winner) {
        if(winner == null) {

            System.out.println("No winners, no chicken dinners :(");
            return;
        }
            System.out.println(winner.toString() + " is the winner! \n " +
                    "Winner winner chicken dinner.");
            return;
        }

    public String toString() {
        return this.name + " " + Character.toString(this.mark);
    }
}
