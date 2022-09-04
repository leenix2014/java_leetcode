public class Solution209 {
    public static void main(String[] args) {
        System.out.println(new Solution209().minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if(n <= 0){
            return 0;
        }

        int start=0, end=0;
        int sum =0;
        int ans = Integer.MAX_VALUE;
        while(end<n) {
            sum += nums[end];
            while (sum >= target){
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }
}
