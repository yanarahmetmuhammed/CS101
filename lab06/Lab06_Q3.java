package lab06;
import java.util.Scanner;

public class Lab06_Q3 {

    public static int[][] multiplyMatrices(int[][] matA, int[][] matB) {
        int[][] result = new int[matA.length][matB[0].length];

        for (int i = 0; i < matA.length; i++) {
            for (int j = 0; j < matB[0].length; j++) {
                for (int k = 0; k < matA[0].length; k++) {
                    result[i][j] += matA[i][k] * matB[k][j];
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter rows for Matrix A: ");
        int rowsA = input.nextInt();

        System.out.print("Enter columns for Matrix A: ");
        int colsA = input.nextInt();

        int[][] matA = new int[rowsA][colsA];

        System.out.println("Enter elements for Matrix A:");
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                matA[i][j] = input.nextInt();
            }
        }

        System.out.print("Enter rows for Matrix B: ");
        int rowsB = input.nextInt();

        System.out.print("Enter columns for Matrix B: ");
        int colsB = input.nextInt();

        int[][] matB = new int[rowsB][colsB];

        System.out.println("Enter elements for Matrix B:");
        for (int i = 0; i < rowsB; i++) {
            for (int j = 0; j < colsB; j++) {
                matB[i][j] = input.nextInt();
            }
        }

        if (colsA != rowsB) {
            System.out.println("Error: Dimensions do not match for multiplication.");
        } else {
            int[][] result = multiplyMatrices(matA, matB);

            System.out.println("Resulting Matrix:");
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }
        }

        input.close();
    }
}
