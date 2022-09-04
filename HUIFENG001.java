import java.util.Scanner;

public class HUIFENG001 {
    public static void main(String[] args) {
        System.out.println(solve());
    }

    public static int solve(){
        //输入：数组长度n，数组element[1]...element[n]，compared K。输出：比K小的元素个数
        //Input:
        //7
        //1 7 4 5 6 3 2
        //5
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();

        int ret=0;
        for(int i=0;i<n;i++){
            if(a[i]<k){
                ret++;
            }
        }
        return ret;
    }
}
