/**
 * @author Leen Li
 */
class Solution1020 {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0,0,0,0},
                {1,0,1,0},
                {0,1,1,0},
                {0,0,0,0}
        };
        System.out.println(new Solution1020().numEnclaves(grid));
    }

    public int numEnclaves(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        //边界侵蚀
        for(int i=0;i<m;i++){
            flood(grid, i, 0);
            flood(grid, i, n-1);
        }
        for(int j=0;j<n;j++) {
            flood(grid, 0, j);
            flood(grid, m-1, j);
        }
        int ans = 0;
        for(int i=0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==1){
                    ans++;
                }
            }
        }
        return ans;
    }

    private void flood(int[][] grid, int i, int j){
        int m=grid.length, n=grid[0].length;
        if(i<0||i>=m || j<0||j>=n){//碰到边界
            return;
        }
        if(grid[i][j]==0){//遇到海水了
            return;
        }
        grid[i][j]=0;//变成海水，避免走回头路死循环
        flood(grid, i-1, j);
        flood(grid, i+1,j);
        flood(grid, i, j-1);
        flood(grid, i, j+1);
    }
}
