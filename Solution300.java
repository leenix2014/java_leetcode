import java.util.Arrays;

/**
 * @author Leen Li
 */
public class Solution300 {
    public static void main(String[] args) {
        System.out.println(new Solution300().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];//dp[i]=nums[i]结尾的最长子序列
        Arrays.fill(dp, 1);//base case，如nums全是递减的情况

        for(int i=0;i<dp.length;i++){//i迭代整个数组
            //假设0...i-1的dp数组已知，求dp[i]
            int max = 0;
            for(int j=0;j<i;j++){//j迭代0...i-1
                if(nums[i]>nums[j]){//有递增的情况则加一
                    max = Math.max(max, dp[j]+1);//找到0...i-1加一后最大的
                }
                //递减无须处理
            }
            dp[i] = max;
        }

        int ans = 0;
        for(int i=0;i<dp.length;i++){
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
