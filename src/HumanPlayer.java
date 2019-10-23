import java.util.Scanner;

public class HumanPlayer extends Player{

    /**
     * Constructor for Player
     *
     * @param name    user input name
     * @param letterX marker (X or O)
     */
    public HumanPlayer(String name, char letterX) {
        super(name, letterX);
    }

    private boolean checkValidInput(String[] input){
        try {
            for (int j = 0; j < input.length; j++) {
                int num = Integer.parseInt(input[j]);
                if ((num > 2) || (num < 0)) {
                    System.out.println("invalid response.");
                    return false;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("invalid response.");
            return false;
        }
        return true;
    }

    private int[] convertResponse(String[] input) {
        int[] output = new int[2];
        for (int j = 0; j < input.length; j++) {
            output[j] = Integer.parseInt(input[j]);
        }
        return output;
    }

    @Override
    public void makeMove(){
        String[] inputsNeeded = {"col", "row"};
        String[] response = new String[2];
        int[] responseInt = new int[2];
        boolean loopFlag = false;
        Scanner scan = new Scanner(System.in);
        System.out.println(this + " Plays.");
        do {
            do {
                for (int i = 0; i < inputsNeeded.length; i++) {
                    System.out.println(inputsNeeded[i]);
                    response[i] = scan.nextLine();
                }
            } while (! checkValidInput(response));
            responseInt = convertResponse(response);
            loopFlag = super.board.addMark(responseInt[1], responseInt[0], super.mark);
        } while (! loopFlag);
    }
}
