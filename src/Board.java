

//STUDENTS SHOULD ADD CLASS COMMENTS, METHOD COMMENTS, FIELD COMMENTS 


public class Board implements Constants {
    private char theBoard[][];
    private int markCount;

    /**
     * Constructor
     */
    public Board() {
        markCount = 0;
        theBoard = new char[3][];
        for (int i = 0; i < 3; i++) {
            theBoard[i] = new char[3];
            for (int j = 0; j < 3; j++)
                theBoard[i][j] = SPACE_CHAR;
        }
    }

    /**
     * Returns the mark on the board at a requested position.
     * @param row
     * @param col
     * @return mark at row, col
     */
    public char getMark(int row, int col) {
        return theBoard[row][col];
    }

    /**
     * Returns true if {@code this.markCount} is equal to 9 (board full)
     * @return
     */
    public boolean isFull() {
        return markCount == 9;
    }

    /**
     * returns true if x wins.
     * @return
     */
    public boolean xWins() {
        if (checkWinner(LETTER_X))
            return true;
        else
            return false;
    }

    /**
     * returns true if O wins
     * @return
     */
    public boolean oWins() {
        if (checkWinner(LETTER_O))
            return true;
        else
            return false;
    }

    /**
     * renders board.
     */
    public void display() {
 //       System.out.println("1");
        displayColumnHeaders();
  //      System.out.println("2");
        addHyphens();
        for (int row = 0; row < 3; row++) {
            addSpaces();
            System.out.print("    row " + row + ' ');
            for (int col = 0; col < 3; col++)
                System.out.print("|  " + getMark(row, col) + "  ");
            System.out.println("|");
            addSpaces();
            addHyphens();
        }
    }

    /**
     * adds a mark to the board
     * @param row
     * @param col
     * @param mark
     */
    public boolean addMark(int row, int col, char mark) {
        if ((theBoard[row][col] == SPACE_CHAR)) {
            theBoard[row][col] = mark;
            markCount++;
            return true;
        }
        System.out.println("invalid selection.");
        return false;
    }

    /**
     * clears the board
     */
    public void clear() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                theBoard[i][j] = SPACE_CHAR;
        markCount = 0;
    }

    /**
     * Checks who is the winner
     * @param mark mark to check the board for.
     * @return returns true if chosen mark won. congrats mark.
     */
    boolean checkWinner(char mark) {
        int row, col;
        int result = 0;

        for (row = 0; result == 0 && row < 3; row++) {
            int row_result = 1;
            for (col = 0; row_result == 1 && col < 3; col++)
                if (theBoard[row][col] != mark)
                    row_result = 0;
            if (row_result != 0)
                result = 1;
        }


        for (col = 0; result == 0 && col < 3; col++) {
            int col_result = 1;
            for (row = 0; col_result != 0 && row < 3; row++)
                if (theBoard[row][col] != mark)
                    col_result = 0;
            if (col_result != 0)
                result = 1;
        }

        if (result == 0) {
            int diag1Result = 1;
            for (row = 0; diag1Result != 0 && row < 3; row++)
                if (theBoard[row][row] != mark)
                    diag1Result = 0;
            if (diag1Result != 0)
                result = 1;
        }
        if (result == 0) {
            int diag2Result = 1;
            for (row = 0; diag2Result != 0 && row < 3; row++)
                if (theBoard[row][3 - 1 - row] != mark)
                    diag2Result = 0;
            if (diag2Result != 0)
                result = 1;
        }
        return result == 1;
    }

    /**
     * Renders column headers
     */
    void displayColumnHeaders() {
        System.out.print("          ");
        for (int j = 0; j < 3; j++)
            System.out.print("|col " + j);
        System.out.println();
    }

    /**
     * renders hyphens
     */
    void addHyphens() {
        System.out.print("          ");
        for (int j = 0; j < 3; j++)
            System.out.print("+-----");
        System.out.println("+");
    }

    /**
     * renders extra spaces
     */
    void addSpaces() {
        System.out.print("          ");
        for (int j = 0; j < 3; j++)
            System.out.print("|     ");
        System.out.println("|");
    }
    public int getMarkCount(){
        return markCount;
    }

    }
