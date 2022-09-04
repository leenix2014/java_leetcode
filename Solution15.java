import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {

    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     * 示例 2：
     *
     * 输入：nums = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：nums = [0]
     * 输出：[]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/3sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new Solution15().threeSum(new int[]{-1,0,1,2,-1,-4}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        if(n<3){
            return ans;
        }

        Arrays.sort(nums);//数组排序

        for(int i=0;i<n;i++){
            if(nums[i]>0){// 如果当前数字大于0，则三数之和一定大于0，所以结束循环
                break;
            }
//            if(i+1<n && nums[i]==nums[i+1]){//错误去重，会导致left指针不能取到重复的-1
//                continue;
//            }
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            //以nums[i]为最小值，找出左指针和右指针三者求和为0的元组
            int left = i+1;
            int right = n-1;
            while(left < right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum==0){
                    ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left<right&&nums[left]==nums[left+1])left++;//去重，仅移动到相同数字最右边
                    while(left<right&&nums[right]==nums[right-1])right--;//去重，仅移动到相同数字最左边
                    left++;//增大sum
                    right--;//减少sum
                }else if(sum <0) {
                    left++;//增大sum
                }else {
                    right--;//减少sum
                }
            }
        }

        return ans;
    }
}
