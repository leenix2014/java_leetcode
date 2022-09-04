import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Leen Li
 */
public class NodeUtil {

    public static void main(String[] args) {
//        TreeNode root = fromBFS(new Integer[]{6,3,5,null,2,0,null,null,1});
        TreeNode root = fromBFS(new Integer[]{2,null,3,null,4,null,5,null,6});
        System.out.println(root);
        System.out.println(root.height());
    }

    public static TreeNode fromBFS(Integer[] nums){
        return buildTree(nums);
    }

    static Queue<TreeNode> queue = new LinkedList<>();
    private static TreeNode buildTree(Integer[] nums){
        if(nums.length == 0){
            return new TreeNode();
        }
        int index = 0;
        TreeNode root = new TreeNode(nums[index]);
        queue.offer(root);

        while (!queue.isEmpty()){
            int sz = queue.size();
            for(int i=0;i<sz;i++){
                TreeNode curr = queue.poll();
                int leftIndex = index+1;
                int rightIndex = index+2;
                if(leftIndex<nums.length) {
                    Integer val = nums[leftIndex];
                    if(val != null) {
                        TreeNode left = new TreeNode(val);
                        curr.left = left;
                        queue.offer(left);
                    }
                    index++;
                }
                if(rightIndex<nums.length) {
                    Integer val = nums[rightIndex];
                    if(val != null) {
                        TreeNode right = new TreeNode(nums[rightIndex]);
                        curr.right = right;
                        queue.offer(right);
                    }
                    index++;
                }
            }
        }
        return root;
    }
}
