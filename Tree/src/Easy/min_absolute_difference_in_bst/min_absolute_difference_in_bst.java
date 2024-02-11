package Easy.min_absolute_difference_in_bst;
import Easy.TreeNode;
/*
    Given the root of binary search tree, return the min abs difference between
    the values of any two different nodes in the tree


    brainstorm: inorder traversal
    because the closest value will be either "left child and root" or "right child and root"

 */
public class min_absolute_difference_in_bst {

    public int min_abs_diff = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root){
        TreeNode prev = null;
        dfs(root, prev);
        return min_abs_diff;
    }
    // inorder traversal
    public void dfs(TreeNode node, TreeNode prev){
        if(node == null){
            return;
        }
        dfs(node.left, prev);
        /* determine if min-abs-value exist */
        if(prev != null){
            min_abs_diff = Math.min(min_abs_diff, Math.abs(prev.val - node.val));
        }
        prev = node;
        dfs(node.right, prev);
    }
}
