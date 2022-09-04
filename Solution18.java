/**
 * 给你一个由 n 个整数组成的数组  nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组  [nums[a], nums[b], nums[c], nums[d]]  （若两个四元组元素一一对应，则认为两个四元组重复）：
 *
 * 0 <= a, b, c, d  < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 *
 *   
 *
 * 示例 1：
 *
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 *
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution18 {
    public static void main(String[] args) {
        System.out.println(new Solution18().fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        if(n<4){
            return ans;
        }
        Arrays.sort(nums);

        for(int i=0;i<n-3;i++){
            if(i>0&&nums[i]==nums[i-1]){//外层循环去重。保持i越小越好
                continue;
            }
            for(int j=i+1;j<n-2;j++){
                if(j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                for(int k=j+1;k<n-1;k++){
                    if(k>j+1&&nums[k]==nums[k-1]){
                        continue;
                    }
                    for(int l=k+1;l<n;l++){
                        if(l>k+1&&nums[l]==nums[l-1]){
                            continue;
                        }
                        long sum=(long)nums[i]+nums[j]+nums[k]+nums[l];
                        if(sum==target){
                            ans.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        }
                    }
                }
            }
        }
        return ans;
    }
}
