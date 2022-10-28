package practice.twoDimensionalArray;

public class TwoDimensionalArray {

    public static final char SYMBOL = 'X';
    public static final char SPACE = ' ';

    public static char[][] getTwoDimensionalArray(int size) {
        char[][] cross = new char[size][size];

        for (int i = 0; i < cross.length; i++) {
            for (int j = 0; j < cross[i].length; j++) {
                if (i == j) {
                    cross[i][j] = SYMBOL;
                    cross[i][size - 1 - j] = SYMBOL;
                } else if (cross[i][j] != SYMBOL) {
                    cross[i][j] = SPACE;
                }
            }
        }

        return cross;
    }
}
