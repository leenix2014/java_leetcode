import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Leen Li
 */
public class NodeUtil {

    public static void main(String[] args) {
        TreeNode root = fromBFS(new Integer[]{6,3,5,null,2,0,null,null,1});
//        TreeNode root = fromBFS(new Integer[]{2,null,3,null,4,null,5,null,6});
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
        TreeNode root = new TreeNode(nums[0]);
        queue.offer(root);

        int level = 1;
        while (!queue.isEmpty()){
            int sz = queue.size();
            for(int i=0;i<sz;i++){
                TreeNode curr = queue.poll();
                int leftMinIndex = (int)Math.pow(2, level)-1;//当前层最左边的索引
//                int rightMaxIndex = (int)Math.pow(2, level+1)-2;//当前层最右边的索引

                int leftIndex = leftMinIndex + 2*i;
                int rightIndex = leftMinIndex + 2*i + 1;
                if(leftIndex<nums.length) {
                    TreeNode left = new TreeNode(nums[leftIndex]);
                    curr.left = left;
                    queue.offer(left);
                }
                if(rightIndex<nums.length) {
                    TreeNode right = new TreeNode(nums[rightIndex]);
                    curr.right = right;
                    queue.offer(right);
                }
            }
            level++;
        }
        return root;
    }
}
