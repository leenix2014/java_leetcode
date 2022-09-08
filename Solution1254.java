/**
 * @author Leen Li
 */
public class Solution1254 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,1,1,1,1,1,1,0},
                {1,0,0,0,0,1,1,0},
                {1,0,1,0,1,1,1,0},
                {1,0,0,0,0,1,0,1},
                {1,1,1,1,1,1,1,0}
        };
        System.out.println(new Solution1254().closedIsland(grid));
    }

    public int closedIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    continue;
                }
                boolean[][] island = new boolean[m][n];
                if(!canReachBoarder(grid, i,j, island)){
                    count++;
                    for(int u=0;u<m;u++){ //数过数了，原来的island删除掉
                        for(int v=0;v<n;v++){
                            if(island[u][v]){
                                grid[u][v]=1;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    private boolean canReachBoarder(int[][] grid, int i, int j, boolean[][] visited){
        int m = grid.length, n = grid[0].length;
        if(i<0||i>=m||j<0||j>=n){
            return true;
        }

        if(grid[i][j]==1){//碰到水
            return false;
        }

        if(visited[i][j]){
            return false;
        }
        visited[i][j]=true;

        return canReachBoarder(grid, i-1, j, visited) ||
                canReachBoarder(grid, i+1, j, visited) ||
                canReachBoarder(grid, i, j-1, visited) ||
                canReachBoarder(grid, i, j+1, visited);
    }
}
