package Easy.max_depth_of_binary_tree;

import Easy.TreeNode;

import java.util.Stack;

/*
    Given the root of a binary tree, return its max depth
    max depth - root -> leaf

 */
public class Max_Depth_Of_Binary_Tree {
    public int maxDepth(TreeNode root){
        return maxDepthHelper(root, 0);
    }
    public int maxDepthHelper(TreeNode node, int depth){
        if(node == null){
            return depth;
        }
        depth += 1;
        return Math.max(maxDepthHelper(node.left, depth), maxDepthHelper(node.right, depth));
    }

    /* way 2: stack - dfs */
    public int maxDepthStack(TreeNode root){
        if(root == null){
            return 0;
        }
        Stack<TreeNodePair> stack = new Stack<>();
        stack.push(new TreeNodePair(root, 0));
        int max_depth=0;
        while(!stack.isEmpty()){
            TreeNodePair treeNodePair = stack.pop();
            TreeNode node = treeNodePair.node;
            int depth = treeNodePair.depth;

            max_depth = Math.max(depth, max_depth);

            if(node.left!=null){
                stack.push(new TreeNodePair(node.left, depth+1));
            }
            if(node.right!=null){
                stack.push(new TreeNodePair(node.right, depth+1));
            }
        }
        return max_depth;
    }
}
