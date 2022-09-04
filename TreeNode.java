import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Leen Li
 */
public class TreeNode {
    Integer val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(Integer val) { this.val = val; }
    TreeNode(Integer val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int height(){
        return this.height0(this);
    }

    private int height0(TreeNode root){
        if(root == null){
            return 0;
        }
        int L = height0(root.left);
        int R = height0(root.right);
        return Math.max(L, R)+1;
    }

    public String toString(){
        return "["+ bfs(this)+"]";
    }

    private String inOrder(TreeNode root){
        if(root == null){
            return "null‘";
        }
        StringBuilder sb = new StringBuilder();
        String left = inOrder(root.left);
        String right = inOrder(root.right);
        return sb.append(left).append(",").append(root.val).append(",").append(right).toString();
    }

    private String bfs(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        StringBuilder sb = new StringBuilder(root.val+"");
        while (!queue.isEmpty()){
            int sz = queue.size();
            for(int i=0;i<sz;i++){
                TreeNode curr = queue.poll();
                if(curr.left == null && curr.right == null) {
                    return sb.toString();
                }
                if(curr.left != null){
                    queue.offer(curr.left);
                    sb.append(",").append(curr.left.val);
                } else {
                    sb.append(",null'");
                }
                if(curr.right != null){
                    queue.offer(curr.right);
                    sb.append(",").append(curr.right.val);
                } else {
                    sb.append(",null'");
                }
            }
        }
        return sb.toString();
    }
}