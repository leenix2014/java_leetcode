/**
 * @author Leen Li
 */
public class HWOD3 {

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int X = in.nextInt();
//        int Y = in.nextInt();
//        int[][] board = new int[X][Y];
//
//        int n = in.nextInt();
//        for(int i=0;i<n;i++){
//            int x = in.nextInt();
//            int y = in.nextInt();
//            board[x][y] = 666;//设置墙壁
//        }

        int X=6,Y=4;
        int[][] board = new int[X][Y];
        visited = new boolean[X][Y];
        touchEnd = new boolean[X][Y];
        for(int i=0;i<X;i++){
            for(int j=0;j<Y;j++){
                board[i][j] = 0;
            }
        }
        board[0][2]=WALL;
        board[1][2]=WALL;
        board[2][2]=WALL;
        board[4][1]=WALL;
        board[5][1]=WALL;

        answer(board, X, Y);
    }

    private static final int WALL = 666;
    private static void answer(int[][] board, int X, int Y){
        backtrack(board, 0,0, X, Y);

        int unreachable = 0;//不可达方格数量
        int trapped = 0; // 陷阱方格数量
        for(int i=0;i<X;i++){
            for(int j=0;j<Y;j++){
                if(board[i][j]==WALL){
                    continue;
                }
                if(!visited[i][j]){//没访问过的地方
                    unreachable++;
                }
                if(visited[i][j] && !touchEnd[i][j]){//访问过，但没法到达终点的地方，是"陷阱"
                    trapped++;
                }
            }
        }

        System.out.print(trapped);
        System.out.print(" ");
        System.out.print(unreachable);
    }


    private static boolean[][] visited;//记录访问过的节点
    private static boolean[][] touchEnd;//记录能到达终点的节点
    private static void backtrack(int[][] board, int i, int j, int X, int Y){
        if(board[i][j]==WALL){//撞墙则返回
            return;
        }
        board[i][j]=1;
        visited[i][j]=true;
        if(i==X-1&&j==Y-1){//到达终点
            for(int u=0;u<X;u++){
                for(int v=0;v<Y;v++){
                    if(board[u][v]==1){
                        touchEnd[u][v]=true;//记录能到达终点的节点
                    }
                }
            }
        }
        //做选择
        if(i+1<X) {
            backtrack(board, i + 1, j, X, Y);//先往右走
        }
        if(j+1<Y){
            backtrack(board, i, j + 1, X, Y);//再往上走
        }
        //回溯
        board[i][j]=0;
    }
}
