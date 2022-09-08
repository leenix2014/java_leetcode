import java.util.LinkedList;
import java.util.List;

/**
 * @author Leen Li
 */
class Solution52 {
    public static void main(String[] args) {
        System.out.println(new Solution52().totalNQueens(8));
    }

    public int totalNQueens(int n) {
        List<String> board = new LinkedList<String>();
        for(int i=0;i<n;i++){
            board.add(emptyRow(n));
        }

        backtrack(board, 0);
        return ans.size();
    }

    List<List<String>> ans = new LinkedList<List<String>>();
    private static final char QUEEN = 'Q';
    private static final char EMPTY = 'O';
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
            board.set(row, change(board.get(row), col, QUEEN));
            backtrack(board, row+1);
            board.set(row, change(board.get(row), col, EMPTY));
        }
    }

    //能否在(row,col)的位置放置皇后
    private boolean isValid(List<String> board, int row, int col){
        int n = board.size();
        //检查左上方是否有皇后
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board.get(i).charAt(j) == QUEEN){
                return false;
            }
        }
        //检查上方是否有皇后
        for(int i=row-1;i>=0;i--){
            if(board.get(i).charAt(col) == QUEEN){
                return false;
            }
        }
        //检查右上方是否有皇后
        for(int i=row-1,j=col+1;i>=0 && j<n;i--,j++){
            if(board.get(i).charAt(j) == QUEEN){
                return false;
            }
        }

        return true;
    }

    private String emptyRow(int n){
        StringBuilder row = new StringBuilder();
        for(int j=0;j<n;j++){
            row.append(EMPTY);
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
