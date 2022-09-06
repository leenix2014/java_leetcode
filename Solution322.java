import java.util.Arrays;

/**
 * @author Leen Li
 */
class Solution322 {
    public static void main(String[] args) {
        System.out.println(new Solution322().coinChange(new int[]{186,419,83,408},6249));
    }
    int[] memo;
    public int coinChange(int[] coins, int amount) {
        memo = new int[amount+1];
        Arrays.fill(memo, -2);
        return dp(coins, amount);
    }

    private int dp(int[] coins, int amount){
        if(amount < 0 ){
            return -1;
        }
        if(amount == 0){
            return 0;
        }

        if(memo[amount]!=-2){
            return memo[amount];
        }

        int min = Integer.MAX_VALUE;
        for(int coin:coins){
            int last = dp(coins, amount-coin);
            if(last == -1){
                continue;
            }
            min = Math.min(min, last+1);
        }
        memo[amount] = min == Integer.MAX_VALUE?-1:min;
        return memo[amount];
    }

}