/*
* This program prints out
* the Magic Sqaures.
*
* @author  Matthew Sanii
* @version 1.0
* @since   2021-12-06
*/

/**
* This is the magic square program.
*/
final class MagicSquare {

    /** The lower right index. */
    public static final int EIGHT = 8;
    /** The middle right index. */
    public static final int FIVE = 5;
    /** The center index. */
    public static final int FOUR = 4;
    /** The maximum number for magicNumbers. */
    public static final int MAGICNUM = 15;
    /** The maximum number for magicNumbers. */
    public static final int NINE = 9;
    /** The lower center index. */
    public static final int SEVEN = 7;
    /** The lower left index. */
    public static final int SIX = 6;
    /** The middle left index. */
    public static final int THREE = 3;

    /**
    * Prevent instantiation
    * Throw an exception IllegalStateException.
    * if this ever is called
    *
    * @throws IllegalStateException
    *
    */
    private MagicSquare() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
    * Recursive Function that creates the magic squares, and runs the checker.
    *
    * @param square the array that has possible values
    * @param currentSquare the array that the values are being put into
    * @param index the index in the array that is being edited
    */
    public static void genSquare(final int[] square, final int[] currentSquare,
                                 final int index) {
        final int[] currentSquared = currentSquare;
        if (currentSquared.length == EIGHT || index == NINE) {
            final boolean check = allDifferent(currentSquared, 0);
            if (check) {
                final boolean ensurance = isMagic(currentSquared);
                if (ensurance) {
                    printMagicSquare(currentSquared);
                }
            }
        }
        else {
            for (int value = 0; value <= EIGHT; value++) {
                currentSquared[index] = value + 1;
                genSquare(square, currentSquared, index + 1);
            }
        }
    }

    /**
    * Function turns rows, collumns and diagonals into integers,
    * and checks if they all equal 15.
    *
    * @param preSquare the array with the 9 values
    * @return are they all equal to 15
    */
    public static boolean isMagic(final int[] preSquare) {
        final int row1 = preSquare[0] + preSquare[1] + preSquare[2];
        final int row2 = preSquare[THREE] + preSquare[FOUR] + preSquare[FIVE];
        final int row3 = preSquare[SIX] + preSquare[SEVEN] + preSquare[EIGHT];
        final int col1 = preSquare[0] + preSquare[THREE] + preSquare[SIX];
        final int col2 = preSquare[1] + preSquare[FOUR] + preSquare[SEVEN];
        final int col3 = preSquare[2] + preSquare[FIVE] + preSquare[EIGHT];
        final int diag1 = preSquare[0] + preSquare[FOUR] + preSquare[EIGHT];
        final int diag2 = preSquare[2] + preSquare[FOUR] + preSquare[SIX];
        return row1 == MAGICNUM && row2 == MAGICNUM && row3 == MAGICNUM
               && col1 == MAGICNUM && col2 == MAGICNUM
               && col3 == MAGICNUM && diag1 == MAGICNUM && diag2 == MAGICNUM;
    }

    /**
    * Function that checks if values in the array are unique.
    *
    * @param finishedSquare the array with the values
    * @param place the spot in the array that is checking the remaining spots
    *
    * @return are they all unique
    */
    public static boolean allDifferent(final int[] finishedSquare,
                                                   final int place) {
        boolean answer = true;
        if (place == EIGHT) {
            answer = true;
        }
        else {
            int result = 0;
            for (int checker = 0; checker <= EIGHT; checker++) {
                if (checker == place) {
                    result += 0;
                }
                else {
                    if (finishedSquare[place] == finishedSquare[checker]) {
                        result += 1;
                    }
                }
            }
            if (result == 0) {
                answer = allDifferent(finishedSquare, place + 1);
            }
            else {
                answer = false;
            }
        }
        return answer;
    }

    /**
    * Function turns array into a 3x3 square.
    *
    * @param outputSquare the square that is being turned into a 3x3 string
    */
    public static void printMagicSquare(final int[] outputSquare) {
        final String barrier = "\n*****";
        final String space = " ";
        System.out.println(barrier);
        for (int count = 0; count < outputSquare.length; count++) {
            if (count == THREE || count == SIX) {
                System.out.println();
                System.out.print(outputSquare[count] + space);
            }
            else {
                System.out.print(outputSquare[count] + space);
            }
        }
        System.out.println(barrier);
    }

    /**
    * The starting main() function.
    *
    * @param args nothing
    * @throws IOException when error occurs
    */
    public static void main(final String[] args) {
        final int[] magicSquare = {1, 2, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE};
        final int[] extraArray = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println("\n");
        System.out.println("All Possible Magic Squares (3x3):\n");
        genSquare(magicSquare, extraArray, 0);
    }
}
