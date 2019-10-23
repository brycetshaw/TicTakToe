public class Referee {
    private Player oPlayer, xPlayer;
    private Board board;

    public Referee(){}

    public void setoPlayer(Player oPlayer) {
        this.oPlayer = oPlayer;
    }

    public void setxPlayer(Player xPlayer) {
        this.xPlayer = xPlayer;
    }

    public void setBoard(Board theBoard) {

        this.board = theBoard;
    }

    public void runTheGame() {
        oPlayer.setOpponent(xPlayer);
        xPlayer.setOpponent(oPlayer);
        board.display();
        xPlayer.play();
    }

}

