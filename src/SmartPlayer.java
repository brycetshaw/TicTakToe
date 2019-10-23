import java.util.ArrayList;

public class SmartPlayer extends BlockingPlayer {

    /**
     * Constructor for Player
     *
     * @param name    user input name
     * @param letterX marker (X or O)
     */
    public SmartPlayer(String name, char letterX) {
        super(name, letterX);
    }

    @Override
    public void makeMove() {
        ArrayList<int[]> validMoves = super.validMoves();
        if(validMoves.size() == 9){
            super.board.addMark(0, 0, super.mark);
            return;
        }

        if(validMoves.size() == 8 && board.getMark(1,1) == Constants.SPACE_CHAR){
            super.board.addMark(1, 1, super.mark);
            return;
        }

        if (super.makeCriticalMove(validMoves, mark, opponent.mark) || super.makeCriticalMove(validMoves, opponent.mark, mark)) {
            return;
        }
        int[] bestMove = validMoves.get(0);
        int bestScore = 0;

//        if(validMoves.size() == 7){
//            for (int[] move: validMoves) {
//                int moveScore = moveScore(move, Constants.SPACE_CHAR, this.opponent.mark);
//                if(moveScore > bestScore){
//                    bestMove = move;
//                    bestScore = moveScore;
//                }
//            }
//            super.board.addMark(bestMove[0], bestMove[1], super.mark);
//        }

        for (int[] move: validMoves) {
            int moveScore = moveScore(move, this.mark, this.opponent.mark);
            if(moveScore > bestScore){
                bestMove = move;
                bestScore = moveScore;
            }
        }
        super.board.addMark(bestMove[0], bestMove[1], super.mark);
    }

    private int moveScore(int[] move, char scoreMark, char ignoreMark) {
        int moveScore = 0;
        moveScore += super.hRankScore(move[1], scoreMark, ignoreMark);
        moveScore += super.vRankScore(move[0], scoreMark, ignoreMark);
        moveScore +=super.dRankScore(move, scoreMark, ignoreMark);
        return moveScore;
    }

}
