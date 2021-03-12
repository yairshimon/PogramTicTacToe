import java.util.Scanner;
public class TicTacToe {
    public static final int ROWS = 3, COLUMNS = 3;
    public static final char[][] matrix = new char[ROWS][COLUMNS];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int o, p;
        initializationMatrix(matrix);
        printMatrix(matrix);
        for (int j = 0; j < ROWS*COLUMNS; j++) {
            do {
                System.out.println("Enter row between 1 to " + ROWS);
                o = scanner.nextInt();
                System.out.println("enter columns between 1 to " + ROWS);
                p = scanner.nextInt();
            } while (((o < 1 || o > ROWS)) || ((p < 1 || p > ROWS)));
                if (matrix[o-1][p-1] == '-') {
                    if (j % 2 == 0)
                        matrix[o-1][p-1] = 'x';
                    if (j % 2 == 1)
                        matrix[o-1][p-1] = '0';
                    printMatrix(matrix);
                    if ((checkWinRows(matrix) == 1) || (checkWinColumns(matrix) == 1) || (checkWinDiagonal(matrix) == 1)) {
                        System.out.println("The winner is the " + matrix[o-1][p-1]);
                        break;
                    }
                }
                else {
                    System.out.println("This position is catch");
                    j--;
                }
            }
            if ((checkWinRows(matrix) == 0) && (checkWinColumns(matrix) == 0) && (checkWinDiagonal(matrix) == 0)) {
            System.out.println("The result is a draw");
        }
    }

    public static void printMatrix(char[][] matrix) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }

    }

    public static void initializationMatrix(char[][] matrix) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                matrix[i][j] = '-';
            }
        }
    }
    public static int checkWinRows(char[][] matrix) {
        int x, o;
        for (int i = 0; i < ROWS; i++) {
            x = 0; o = 0;
            for (int j = 0; j < COLUMNS; j++) {
                if (matrix[i][j] == 'x')
                    x++;
                if (matrix[i][j] == '0')
                    o++;
                if (x == ROWS)
                    return 1;
                if (o == ROWS)
                    return 1;
            }
        }
        return 0;
    }
    public static int checkWinColumns(char[][] matrix) {
        int x, o;
        for (int i = 0; i < ROWS; i++) {
            x = 0; o = 0;
            for (int j = 0; j < COLUMNS; j++) {
                if (matrix[j][i] == 'x')
                    x++;
                if (matrix[j][i] == '0')
                    o++;
                if (x == ROWS)
                    return 1;
                if (o == ROWS)
                    return 1;
            }
        }
        return 0;
    }
    public static int checkWinDiagonal(char[][] matrix) {
        int x = 0, o = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if ((i == j) && (matrix[i][j] == 'x'))
                        x++;
            }
        }
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if ((i == j) && (matrix[i][j] == '0'))
                o++;
            }
        }
        if (x == ROWS){
            return 1;
        }
        if (o == ROWS){
            return 1;
        }
        return 0;
    }
}