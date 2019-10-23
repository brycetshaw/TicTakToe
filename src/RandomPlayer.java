import java.util.ArrayList;
import java.util.Random;

public class RandomPlayer extends Player{

    /**
     * Constructor for Player
     *
     * @param name    user input name
     * @param letterX marker (X or O)
     */
    public RandomPlayer(String name, char letterX) {
        super(name, letterX);
    }

    @Override
    public void makeMove() {
        ArrayList<int[]> validMoves =  validMoves();
        makeRandomMove(validMoves);
    }

    protected void makeRandomMove(ArrayList<int[]> validMoves){
        Random rand = new Random();
        int[] move = validMoves.get(rand.nextInt(validMoves.size()));
        super.board.addMark(move[0], move[1], super.mark);
    }

    protected ArrayList<int[]> validMoves(){
        ArrayList<int[]> validSet = new ArrayList<int[]>();
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(super.board.getMark(i,j) == Constants.SPACE_CHAR){
                    int[] newMove = new int[2];
                    newMove[0] = i;
                    newMove[1] = j;
                    validSet.add(newMove);
                }
            }
        }
        return validSet;
    }

}
