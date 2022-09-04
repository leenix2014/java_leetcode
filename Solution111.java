/**
 * @author Leen Li
 */
public class Solution111 {
    public static void main(String[] args) {
        TreeNode root = NodeUtil.fromBFS(new Integer[]{2,null,3,null,4,null,5,null,6});
        System.out.println(root);
        System.out.println(root.height());
        System.out.println(new Solution111().minDepth(root));
    }

    int min = 0;
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftMin = minDepth(root.left);
        int rightMin = minDepth(root.right);
        return Math.min(leftMin+1, rightMin+1);
    }
}
