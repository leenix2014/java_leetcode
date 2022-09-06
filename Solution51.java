import java.util.LinkedList;
import java.util.List;

/**
 * @author Leen Li
 */
class Solution51 {
    private static final char queen = 'Q';
    private static final char empty = 'O';

    public static void main(String[] args) {
        List<List<String>> result = new Solution51().solveNQueens(8);
        System.out.println(result);
    }

    public List<List<String>> solveNQueens(int n) {
        List<String> board = new LinkedList<String>();
        for(int i=0;i<n;i++){
            board.add(emptyRow(n));
        }

        backtrack(board, 0);
        return ans;
    }

    List<List<String>> ans = new LinkedList<List<String>>();
    private void backtrack(List<String> board, int row){
        if(row == board.size()){
            ans.add(new LinkedList(board));
            return;
        }
        int n = board.size();
        for(int col=0;col<n;col++){
            if(!isValid(board, row, col)){
                continue;
            }
            board.set(row, change(board.get(row), col, queen));
            backtrack(board, row+1);
            board.set(row, change(board.get(row), col, empty));
        }
    }

    //能否在(row,col)的位置放置皇后
    private boolean isValid(List<String> board, int row, int col){
        int n = board.size();
        //检查左上方是否有皇后
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board.get(i).charAt(j) == queen){
                return false;
            }
        }
        //检查上方是否有皇后
        for(int i=row-1;i>=0;i--){
            if(board.get(i).charAt(col) == queen){
                return false;
            }
        }
        //检查右上方是否有皇后
        for(int i=row-1,j=col+1;i>=0 && j<n;i--,j++){
            if(board.get(i).charAt(j) == queen){
                return false;
            }
        }

        return true;
    }

    private String emptyRow(int n){
        StringBuilder row = new StringBuilder();
        for(int j=0;j<n;j++){
            row.append(empty);
        }
        return row.toString();
    }

    private String change(String str, int col, char c){
        char[] chars = new char[str.length()];
        for(int i=0;i<chars.length;i++){
            if(i==col){
                chars[i]=c;
                continue;
            }
            chars[i] = str.charAt(i);
        }
        return new String(chars);
    }
}
