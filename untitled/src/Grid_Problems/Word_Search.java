package Grid_Problems;
/*
    Given a mxn grid of characters "board" and a string "word", return "true" if "word" exists in the grid

    adjacent cells (horizontal, vertical neighboring)

    dfs + backtrack


    1. find the first char of the target word
    2. stops when the index of search equals to target word length
    3. store the current position char of the board, and replace with empty char
    4. search 4 directions around
    5. place the char stored back to the board
    6. if any direction matches returns true

 */

public class Word_Search {
    public static boolean exist(char[][] board, String word){
        if(board == null){
            return false;
        }
        if(word == null){
            return true;
        }
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                // every time start from searching the first character of the target word
                if(board[i][j] == word.charAt(0)){
                    if(dfs(i, j, 0, board, word)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean dfs(int row, int col, int index, char[][] board, String word){
        if(index == word.length()){
            return true;
        }
        if(row < 0 || row > board.length -1 || col < 0 || col > board[0].length
                || board[row][col] != word.charAt(index)
        ){
            return false;
        }

        char currChar = board[row][col];
        board[row][col] = ' ';
        boolean found = dfs(row+1, col, index+1, board, word) || dfs(row, col+1, index+1, board, word) || dfs(row-1, col, index+1, board, word) || dfs(row, col-1, index+1, board, word);
        board[row][col] = currChar;
        return found;

    }
}
