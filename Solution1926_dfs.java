/**
 * @author Leen Li
 */
public class Solution1926_dfs {
    public static void main(String[] args) {
        char[][] maze = new char[][]{
                {'+','.','+','+','+','+','+'},
                {'+','.','+','.','.','.','+'},
                {'+','.','+','.','+','.','+'},
                {'+','.','.','.','.','.','+'},
                {'+','+','+','+','.','+','.'}
        };
        int[] entrance = new int[]{0,1};
        System.out.println(new Solution1926_dfs().nearestExit(maze, entrance));
    }


    public int nearestExit(char[][] maze, int[] entrance) {
        int m=maze.length, n=maze[0].length;
        visited = new boolean[m][n];
        int ans = dfs(maze, entrance[0], entrance[1], 0, entrance);
        return ans == Integer.MAX_VALUE?-1:ans;
    }

    boolean[][] visited;

    int dfs(char[][] maze, int i, int j, int step, int[] entrance){
        int m=maze.length, n=maze[0].length;
        if(i<0||i>=m||j<0||j>=n){
            return Integer.MAX_VALUE;
        }
        if(maze[i][j]!='.'){
            return Integer.MAX_VALUE;
        }
        if(!(i==entrance[0] && j==entrance[1]) &&
                (i<=0||i>=m-1 || j<=0||j>=n-1)){
            return step;
        }
        if(visited[i][j]){
            return Integer.MAX_VALUE;
        }
        visited[i][j]=true;
        int min = Math.min(Math.min(Math.min(dfs(maze, i-1, j, step+1, entrance),
        dfs(maze, i+1, j, step+1, entrance)),
        dfs(maze, i, j-1, step+1, entrance)),
        dfs(maze, i, j+1, step+1, entrance));
        visited[i][j]=false;
        return min;
    }
}
