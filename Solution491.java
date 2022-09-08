import java.util.*;

/**
 * @author Leen Li
 */
class Solution491 {

    public static void main(String[] args) {
        System.out.println(new Solution491().findSubsequences(new int[]{-100,-100,0,0,0,100,100,0,0}));
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        if(nums.length < 2){
            return ans;
        }
        LinkedList<Integer> path = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for(int i=0;i<nums.length;i++) {
            if(visited.contains(nums[i])){
                continue;
            }
            path.add(nums[i]);
            visited.add(nums[i]);
            backtrack(nums, i, path);
            path.removeLast();
        }
        return ans;
    }

    List<List<Integer>> ans = new LinkedList<>();
    void backtrack(int[] nums, int i, LinkedList<Integer> path){
        if (i>=nums.length){
            return;
        }

        Set<Integer> visited = new HashSet<>();
        for(int j=i+1;j<nums.length;j++) {
            if(nums[j]<nums[i]){
                continue;
            }
            if(visited.contains(nums[j])){
                continue;
            }
            path.add(nums[j]);
            visited.add(nums[j]);
            ans.add(new LinkedList<>(path));
            backtrack(nums, j, path);
            path.removeLast();
        }
    }
}
