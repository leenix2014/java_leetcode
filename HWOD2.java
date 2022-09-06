import java.util.Scanner;

/**
 * @author Leen Li
 */
public class HWOD2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        System.out.println(answer(n));

//        System.out.println(answer(100));
    }

    private static long answer(long n){
        int actual = 0;
        for(long i=1;i<=n;i++){
            if(has4(i)){
                continue;
            }
            actual++;
        }
        return actual;
    }

    private static boolean has4(long n){
        boolean has4 = n%10 == 4;
        while (!has4 && n>10){
            n = n/10;
            has4 = n%10 == 4;
        }
        return has4;
    }
}
