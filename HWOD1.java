import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HWOD1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int[] a1 = new int[m];
        for(int i=0;i<m;i++){
            a1[i] = in.nextInt();
        }
        int n = in.nextInt();
        int[] a2 = new int[n];
        for(int i=0;i<n;i++){
            a2[i] = in.nextInt();
        }
        int k = in.nextInt();
        if(m==0||n==0||k==0){//单个数组无法组成配对
            System.out.println(0);
            return;
        }

        System.out.println(answer(a1,a2,k));

//        System.out.println(answer(new int[]{100,101,102}, new int[]{1,2,3,4,5}, 15));
    }

    private static long answer(int[] a1, int[]a2, int k){
        int m = a1.length, n = a2.length;
        int up=0,down = 0;//数组1和数组2索引
        long ans = 0;//必须使用long
        boolean moveUp;//true=移动数组1的指针,false=移动数组2的指针
        while (k>0) {
            //找出当前最大值
            if (a1[up] > a2[down]) {
                if(down == n-1){
                    moveUp = true;
                } else {
                    moveUp = false;
                }
            } else {
                if(up == m-1){
                    moveUp = false;
                } else {
                    moveUp = true;
                }
            }
            //配对求和
            ans += a1[up] + a2[down];
            //移动指针
            if (moveUp) {
                up++;
                down = 0;
            } else {
                down++;
                up = 0;
            }
            k--;
        }

        return ans;
    }
}