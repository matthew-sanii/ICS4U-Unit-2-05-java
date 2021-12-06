/*
* This program prints out
* the Magic Sqaures.
*
* @author  Nicholas B. & Mr. Coxall
* @version 1.0
* @since   2020-01-01
*/

final class MagicSquare {

    private MagicSquare() {
        // Prevent instantiation
        // Optional: throw an exception e.g. AssertionError
        // if this ever *is* called
        throw new IllegalStateException("Cannot be instantiated");
    }

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

    public static void genSquare(final int[] square, final int[] currentSquare,
                                 final int index) {
        int[] currentSquared = currentSquare;
        if (currentSquared.length == 8 || index == 9) {
            final boolean check = allDifferent(currentSquared, 0);
            if (check == true) {
                final boolean ensurance = isMagic(currentSquared);
                if (ensurance == true) {
                    printMagicSquare(currentSquared);
                }
            }
        }
        else {
            for (int value = 0; value <= 8; value++) {
                currentSquared[index] = value + 1;
                genSquare(square, currentSquared, index + 1);
            }
        }
    }

    public static boolean isMagic(final int[] preSquare) {
        // returns true or false for whether or not array is a magic square
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

    public static boolean allDifferent(final int[] finishedSquare,
                                                   final int place) {
        if (place == 8) {
            return true;
        }
        int result = 0;
        boolean answer = true;
        for (int checker = 0; checker <= 8; checker++) {
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
        return answer;
    }

    public static void printMagicSquare(final int[] outputSquare) {
        // prints inputted array in a magic square format
        final String barrier = "\n*****";
        System.out.println(barrier);
        for (int count = 0; count < outputSquare.length; count++) {
            if (count == THREE || count == SIX) {
                System.out.println();
                System.out.print(outputSquare[count] + " ");
            } else {
                System.out.print(outputSquare[count] + " ");
            }
        }
        System.out.println(barrier);
    }

    public static void main(final String[] args) {
        // main stub, get user input here
        int[] magicSquare = {1, 2, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE};
        int[] extraArray = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println("\n");
        System.out.println("All Possible Magic Squares (3x3):\n");
        genSquare(magicSquare, extraArray, 0);
    }
}
