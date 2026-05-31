package lab06;
import java.util.Scanner;


public class Lab06_Q1 {

    public static boolean isPeak(int[][] grid, int row, int col) {
        if (row > 0 && grid[row][col] <= grid[row - 1][col]) {
            return false;
        }

        if (row < grid.length - 1 && grid[row][col] <= grid[row + 1][col]) {
            return false;
        }

        if (col > 0 && grid[row][col] <= grid[row][col - 1]) {
            return false;
        }

        if (col < grid[0].length - 1 && grid[row][col] <= grid[row][col + 1]) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int r = input.nextInt();

        System.out.print("Enter number of columns: ");
        int c = input.nextInt();

        int[][] grid = new int[r][c];

        System.out.println("Enter elevations:");
        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {
                grid[row][col] = input.nextInt();
            }
        }

        System.out.println("Terrain Map:");
        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {
                System.out.print(grid[row][col] + " ");
            }
            System.out.println();
        }

        boolean found = false;
        System.out.println("Peaks found:");

        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {
                if (isPeak(grid, row, col)) {
                    System.out.println("Peak at (" + row + ", " + col + ") with elevation " + grid[row][col]);
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No peaks detected.");
        }

        input.close();
    }
}