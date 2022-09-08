import java.util.*;

/**
 * @author Leen Li
 */
public class Solution1926_bfs {

    public static void main(String[] args) {
        char[][] maze = new char[][]{
                {'+','.','+','+','+','+','+'},
                {'+','.','+','.','.','.','+'},
                {'+','.','+','.','+','.','+'},
                {'+','.','.','.','.','.','+'},
                {'+','+','+','+','.','+','.'}
        };
        int[] entrance = new int[]{0,1};
        System.out.println(new Solution1926_bfs().nearestExit(maze, entrance));
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        return bfs(maze, entrance);
    }

    int bfs(char[][] maze, int[] entrance){
        int m=maze.length, n=maze[0].length;
        Set<Point> visited = new HashSet<>();
        Queue<Point> q = new LinkedList<>();
        Point entry = new Point(entrance[0], entrance[1]);
        q.offer(entry);
        visited.add(entry);

        int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        int step = 0;
        while (!q.isEmpty()){
            int sz = q.size();
            for(int i=0;i<sz;i++){
                Point curr = q.poll();
                int u = curr.x;
                int v = curr.y;
                if(!(u==entrance[0] && v==entrance[1]) &&
                        (u<=0||u>=m-1 || v<=0||v>=n-1)){
                    return step;
                }

                for(int[] dir : dirs){
                    int x = u+dir[0];int y= v+dir[1];
                    if(x<0||x>=m||y<0||y>=n){
                        continue;
                    }
                    if(maze[x][y]!='.'){
                        continue;
                    }
                    Point next = new Point(x,y);
                    if(visited.contains(next)){
                        continue;
                    }
                    q.offer(next);
                    visited.add(next);
                }
            }
            step++;
        }
        return -1;
    }

    class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if(!(obj instanceof Point)){
                return false;
            }
            Point point = (Point) obj;
            return this.x == point.x && this.y == point.y;
        }

        @Override
        public int hashCode(){
            return Objects.hash(this.x, this.y);
        }
    }
}
