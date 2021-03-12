import java.util.Scanner;

public class MultiplicationOfMatrices {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a value for matrix1: ");
        int[][] matrix1 = createMatrix();
        System.out.println("Enter a value for matrix2: ");
        int[][] matrix2 = createMatrix();
        System.out.println("Matrix 1 is\n");
        printMatrix(matrix1);
        System.out.println("\n\nMatrix 2 is");
        printMatrix(matrix2);
        System.out.println("\nPress any button on the keyboard for see multiplication of the matrices ");
        int press = scanner.nextInt();
        if (checkMultiplicationMatrix(matrix1, matrix2)) {
            int[][] resultMatrix = multiplicationMatrix(matrix1, matrix2);
            System.out.println();
            printResult(resultMatrix);
        } else
            System.out.println("The matrix cannot get multiplication");
    }
    public static void printMatrix(int [][]matrix) {
        for (int[] ints : matrix) {
            System.out.println();
            for (int anInt : ints) {
                System.out.print(" " + anInt);
            }
        }
    }
    public static int[][] createMatrix(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows you want:");
        int rowsMatrix = scanner.nextInt();
        System.out.println("Enter the number of columns you want:");
        int columnsMatrix = scanner.nextInt();
        int[][] userMatrix = new int[rowsMatrix][columnsMatrix];
        for(int i = 0; i < userMatrix.length; i++){
            for(int j = 0 ; j < userMatrix[i].length; j++){
                System.out.println("Enter a number for matrix["+i+"]["+j+"]: ");
                userMatrix[i][j] = scanner.nextInt();
            }
        }
        return userMatrix;
    }

    public static boolean checkMultiplicationMatrix (int[][] matrix1, int[][] matrix2){
        int columnsMatrix1 = matrix1[0].length;
        int rowsMatrix2 = matrix2.length;
        return columnsMatrix1 == rowsMatrix2;
    }

    public static int[][] multiplicationMatrix (int[][] matrix1, int[][] matrix2){
        int row = matrix1.length;
        int column = matrix2[0].length;
        int[][] resultMatrix = new int[row][column];
        for (int k = 0; k < resultMatrix.length; k++) {
            for (int g = 0; g < resultMatrix[k].length; g++) {
                for (int i = 0; i < matrix1.length; i++) {
                    int currentCell = 0;
                    for (int j = 0; j < matrix2.length; j++) {
                        currentCell += matrix1[i][j] * matrix2[j][g];
                    }
                    resultMatrix[i][g] = currentCell;
                }
            }
        }
        return resultMatrix;
    }

    public static void printResult (int[][] multiplicationMatrix) {
        System.out.println();
        System.out.println("The multiplication of the matrices is");
        for (int[] matrix : multiplicationMatrix) {
            for (int i : matrix) {
                System.out.print(i + "  ");
            }
            System.out.println();
        }
    }
}
