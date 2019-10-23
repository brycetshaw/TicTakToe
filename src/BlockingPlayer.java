import java.util.ArrayList;

public class BlockingPlayer extends RandomPlayer {

    /**
     * Constructor for Player
     *
     * @param name    user input name
     * @param letterX marker (X or O)
     */
    public BlockingPlayer(String name, char letterX) {
        super(name, letterX);
    }

    @Override
    public void makeMove() {
        ArrayList<int[]> validMoves = super.validMoves();

        if (makeCriticalMove(validMoves, opponent.mark, mark)){
            return;
        }
        super.makeRandomMove(validMoves);
    }

    protected boolean makeCriticalMove(ArrayList<int[]> validMoves, char blockMark, char otherMark) {

        for (int[] move : validMoves) {

            if      ((vRankScore(move[0], blockMark, otherMark) > 1) ||
                    (hRankScore(move[1], blockMark,otherMark) > 1) ||
                    ((dRankScore(move, blockMark, otherMark) > 1))) {
                super.board.addMark(move[0], move[1], super.mark);
                return true;
            }
        }
        return false;
    }

    protected int dRankScore(int[] move, char scoreMark, char ignoreMark) {
        if (!(Math.abs(move[0] - move[1]) == 2 || (move[0] == move[1]))){
            return 0;
        }

        int rankScore = 0;
        if (move[0] == move[1]) {
            return dDwnRankScore(move,scoreMark, ignoreMark);
        } else {
            return  dUpRankScore(move,scoreMark, ignoreMark);
        }
    }

    protected int dDwnRankScore(int[] move, char scoreMark, char ignoreMark) {
        int rankScore = 0;
        for (int i = 0; i < 3; i++) {
            if (board.getMark(i, i) == scoreMark){
                rankScore += 1;
            }
            if(board.getMark(i, i) == ignoreMark){
                return 0;
            }
        }
        return rankScore;
    }

    protected int dUpRankScore(int[] move, char scoreMark, char ignoreMark) {
        int rankScore = 0;
            for (int i = 0; i < 3; i++) {
                if (board.getMark(2-i, i) == scoreMark){
                    rankScore += 1;
                }
                if(board.getMark(2-i, i) == ignoreMark){
                    return 0;
                }
        }
        return rankScore;
    }




    protected int vRankScore(int x, char scoreMark, char ignoreMark) {
        int vrankScore = 0;
        for (int i = 0; i < 3; i++) {
            if (board.getMark(x, i) == scoreMark) {
                vrankScore += 1;
            }
            if(board.getMark(x, i) == ignoreMark){
                return 0;
            }
        }
        return vrankScore;
    }

    protected int hRankScore(int y, char scoreMark, char ignoreMark) {
        int hrankScore = 0;
        for (int i = 0; i < 3; i++) {
            if (board.getMark(i, y) == scoreMark) {
                hrankScore += 1;
            }
            if(board.getMark(i, y) == ignoreMark){
                return 0;
            }
        }
        return hrankScore;
    }
}
