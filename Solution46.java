import java.util.LinkedList;
import java.util.List;

/**
 * @author Leen Li
 */
class Solution46 {

    public static void main(String[] args) {
        System.out.println(new Solution46().permute(new int[]{1,2,3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        traverse(nums, visited);
        return ans;
    }

    List<List<Integer>> ans = new LinkedList();
    LinkedList<Integer> list = new LinkedList();
    private void traverse(int[] nums, boolean[] visited){
        if(list.size()==nums.length){
            ans.add(new LinkedList(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(visited[i]){
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            traverse(nums, visited);
            list.removeLast();
            visited[i] = false;
        }
    }
}
