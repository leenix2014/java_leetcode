/**
 * @author Leen Li
 */
public class Solution654 {

    public static void main(String[] args) {
        System.out.println(new Solution654().constructMaximumBinaryTree(new int[]{3,2,1,6,0,5}));
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length);
    }

    //start为闭区间，end为开区间
    private TreeNode buildTree(int[] nums, int start, int end){
        if(start >= end){
            return null;
        }

        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for(int i=start;i<end;i++){
            if(nums[i] > max){
                max = nums[i];
                maxIndex = i;
            }
        }

        TreeNode root = new TreeNode(max);
        root.left = buildTree(nums, start, maxIndex);
        root.right = buildTree(nums, maxIndex+1, end);
        return root;
    }
}
