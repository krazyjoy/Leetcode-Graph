import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
    public static List<List<String>> solveNQueens(int n){
        char[][] grid = new char[n][n];

        // fill grid with all '.'s
        for(char[] row: grid){
            Arrays.fill(row, '.');
        }

        // change grid to List<List<String>>
        List<List<String>> result = new ArrayList<>();
        backtrack(result, grid, 0);
        return result;
    }

    public static void backtrack(List<List<String>> result, char[][] grid, int row){
        if(row == grid.length){

            result.add(buildsolution(grid));
            return;
        }
        int n = grid[row].length;
        for(int col=0; col<n; col++){
            if(!isValid(grid, row, col)){
                continue;
            }
            grid[row][col] = 'Q';
            backtrack(result, grid, row+1);
            grid[row][col] = '.';
        }
    }

    public static List<String> buildsolution(char[][] grid){
        List<String> solution = new ArrayList<>();
        for(char[] row: grid){
            String rowString = new String(row);
            solution.add(rowString);
        }

        return solution;
    }

    public static  boolean isValid(char[][] grid, int row, int col){
        // same column
        for(int r=0; r<grid.length; r++){
            if(grid[r][col] == 'Q'){
                return false;
            }
        }
        // right diagonal before to current row /
        for(int i=row-1, j=col+1; i>=0 && j < grid.length; i--, j++){
            if(grid[i][j] == 'Q'){
                return false;
            }
        }

        // left diagonal after current row \
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
            if(grid[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
}
