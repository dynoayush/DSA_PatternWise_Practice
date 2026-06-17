// Word Search [LC-79]

public class Q68 {
    private int m,n;

    private int[][] directions = {
        {1,0},
        {0,1},
        {0,-1},
        {-1,0}
    };

    public boolean exist(char[][] board, String word){
        m = board.length;
        n = board[0].length;

        for(int  i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(board[i][j] == word.charAt(0) && find(board, i,j, 0, word)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean find(char[][] board, int i, int j, int index, String word){
        if(index == word.length()) return true;
        
        if(i<0 || j<0 || i>=m || j>=n || board[i][j] == '$' || board[i][j] != word.charAt(index)){
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '$';

        for(int[]dir : directions){
            int new_i = i + dir[0];
            int new_j = j + dir[1];
            if(find(board, new_i, new_j, index+1, word)){
                board[i][j] = temp; // restore before returning 
                return true;
            }
        }
        board[i][j] = temp; // backtrack
        return false;
    }

    public static void main(String[] args) {
        Q68 sol = new Q68();

        char[][] board = {
        {'A','B','C','E'},
        {'S','F','C','S'},
        {'A','D','E','E'}
    };

    String word = "ABCCED";

    System.out.println(sol.exist(board, word));
    }
}
