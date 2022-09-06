import java.util.LinkedList;
import java.util.List;

/**
 * @author Leen Li
 */
public class Solution37 {

    public static void main(String[] args) {
        char[][] board = new char[][]{{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        new Solution37().solveSudoku(board);
    }

    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
        if(res.size()>0) {
            char[][] ans = res.get(0);
            for(int u=0;u<9;u++){
                for(int v=0;v<9;v++){
                    board[u][v] = ans[u][v];
                }
            }
        }
    }

    List<char[][]> res = new LinkedList<>();
    private void backtrack(char[][] board, int i, int j){
        if(j==9){//列到达终点后，开始新的一行
            backtrack(board, i+1,0);
            return;
        }
        if(i==9){//行到达终点
            char[][] ans = new char[9][9];
            for(int u=0;u<9;u++){
                for(int v=0;v<9;v++){
                    ans[u][v] = board[u][v];
                }
            }
            res.add(ans);
            return;
        }
        if(board[i][j]!='.'){//已有数字，进入下一列
            backtrack(board, i, j+1);
            return;
        }

        for(char c='1';c<='9';c++) {
            if(!matchRule(board, i, j, c)){
                continue;
            }
            board[i][j] = c;
            backtrack(board, i, j + 1);
            board[i][j] = '.';
        }
    }

    private boolean matchRule(char[][] board, int i, int j, char c){
        //看看行是否有重复
        for(int u=0;u<9;u++){
            if(board[u][j] == c){
                return false;
            }
        }
        //检查列是否有重复
        for(int v=0;v<9;v++){
            if(board[i][v] == c){
                return false;
            }
        }
        //检查3*3表格是否有重复
        for(int w=0;w<9;w++){
            int row = (i/3)*3 + w/3;
            int col = (j/3)*3 + w%3;
            if(board[row][col] == c){
                return false;
            }
        }
        return true;
    }
}
