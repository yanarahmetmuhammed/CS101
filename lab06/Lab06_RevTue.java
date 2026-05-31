package lab06;
import java.util.Scanner;


public class Lab06_RevTue {

    /*public static boolean isPeak(int[][] grid, int row, int col) {
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
    */
    public static boolean isValidZone(int[][] grid, int row, int col, int k,int maxVariance , int c){
        int max = grid[row][col];
        int min = grid[row][col];

        for (int rowA = row; (rowA < row + k) ; rowA++) {
            for (int colA = col; colA < col + k; colA++) {
                if(max < grid[rowA][colA]){
                    max = grid[rowA][colA];    
                }
                
                if(min > grid[rowA][colA]){
                    min = grid[rowA][colA];
                }
            }
        }
        
        if(max - min <= maxVariance){
            return true;
        }
        return false;
            
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
        
        System.out.println("Enter landing pad size K:");
        int k = input.nextInt();
        System.out.println("Enter max variance T:");
        int maxVariance = input.nextInt();

        for (int row = 0; row < r - k + 1; row++) {
            for (int col = 0; col < c - k + 1 ; col++) {
                if (isValidZone(grid, row, col, k, maxVariance , c)) {
                    System.out.println("Landing zone found at (" + row + ", " + col + ") with varience " + maxVariance);
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No valid landing zone found.");
        }

        input.close();
    }
}