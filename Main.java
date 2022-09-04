import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main{
    public  static void  main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> inputs = new HashSet<>();
        for(int i=0;i<n;i++){
            inputs.add(br.readLine());
        }
        int[] ans = new int[inputs.size()];
        int index = 0;
        for(String input: inputs){
            ans[index] = Integer.parseInt(input);
            index++;
        }
        Arrays.sort(ans);
        Arrays.stream(ans).forEach(System.out::println);
    }
}