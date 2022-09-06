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
    public int minDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        if (node.left == null) {
            return 1 + minDepth(node.right);
        }

        if (node.right == null) {
            return 1 + minDepth(node.left);
        }

        int leftDepth = minDepth(node.left);
        int rightDepth = minDepth(node.right);
        return 1 + Math.min(leftDepth, rightDepth);
    }
}
