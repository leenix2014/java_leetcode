import java.util.Scanner;

public class HUIFENG002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int[][] locCord = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                locCord[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solve(n,m,locCord));
    }

    public static int solve(int n, int m, int[][] locCord){
        /**
         * 输入：
         * n:线段数量，m：线段坐标数量，二维平面固定是4
         * 线段1的坐标...
         * 线段n的坐标
         *
         * 输出：线段的交点个数
         *
         * Input:
         * 3 4
         * 1 1 4 5
         * 0 3 3 2
         * 2 4 5 3
         *
         * Output:
         * 2
         */
        Line[] lines = new Line[n];
        for(int i=0;i<n;i++){
            lines[i] = new Line(new Point(locCord[i][0], locCord[i][1]), new Point(locCord[i][2], locCord[i][3]));
        }

        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if (lines[i].intersectsWith(lines[j])){
                    ans++;
                    System.out.println(lines[i].toString()+" intersects with "+lines[j].toString());
                }
            }
        }

        return ans;
    }

    static class Point{
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        int x;
        int y;

        @Override
        public String toString() {
            return "("+x+","+y+")";
        }
    }

    static class Line{
        Line(Point a, Point b){
            this.a = a;
            this.b = b;
        }
        Point a;
        Point b;

        @Override
        public String toString() {
            return "{"+a.toString()+","+b.toString()+"}";
        }

        boolean intersectsWith(Line line){
            Point A = this.a;
            Point B = this.b;
            Point C = line.a;
            Point D = line.b;
            //投影不相交，直接排除
            if(Math.max(A.x, B.x) < Math.min(C.x, D.x) ||
                    Math.max(C.x, D.x) < Math.min(A.x, B.x) ||
                    Math.max(A.y, B.y) < Math.min(C.y, D.y) ||
                    Math.max(C.y, D.y) < Math.min(A.y, B.y)
            ){
                return false;
            }
            //向量相减后的向量，用Point表示
            Point DA = new Point(A.x-D.x, A.y-D.y);//A-D
            Point DB = new Point(B.x-D.x, B.y-D.y);//B-D
            Point DC = new Point(C.x-D.x, C.y-D.y);//C-D

            Point BC = new Point(C.x-B.x, C.y-B.y);//C-B
            Point BD = new Point(D.x-B.x, D.y-B.y);//D-B
            Point BA = new Point(A.x-B.x, A.y-B.y);//A-B

            // (A−D)×(C−D)∗(B−D)×(C−D)<=0 && (D−B)×(A−B)∗(C−B)×(A−B)<=0 则相交
            if(cross(DA.x, DA.y, DC.x, DC.y)*cross(DB.x,DB.y, DC.x, DC.y)<=0
                &&cross(BD.x, BD.y, BA.x, BA.y)*cross(BC.x, BC.y, BA.x, BA.y)<=0){
                return true;
            }
            return false;
        }

        public int cross(int x1, int y1, int x2, int y2) {
            return x1 * y2 - x2 * y1;
        }
    }
}
