import java.util.Arrays;

public class HUIFENG003 {
    public static void main(String[] args) {
        System.out.println(minProject(new int[]{6,4,1}, 4, 1));
    }
    public static int  minProject(int[] errorScore, int compP, int othQ)
    {
        int  answer = 0;
        // Write your code here
        int n = errorScore.length;
        if(n<=0){
            return answer;
        }

        while(true){
            int maxScoreIndex = 0;
            for (int i = 0; i < n; i++) {
                if (errorScore[i] > errorScore[maxScoreIndex]) {
                    maxScoreIndex = i;
                }
            }
            if(errorScore[maxScoreIndex]<=0){
                return answer;
            }
            for(int i=0;i<n;i++){
                if(i==maxScoreIndex){
                    errorScore[i] -= compP;
                    continue;
                }
                errorScore[i] -= othQ;
            }
            answer++;
        }
    }
}
