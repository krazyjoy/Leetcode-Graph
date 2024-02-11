package tree_construction.populate_next_right_node;

import java.util.LinkedList;
import java.util.Queue;

/*
    root -> null
    root.right -> null
    the rightmost node always points to null

    use queue to remember left nodes by storing it after right node
    in each level first init rightnode to null
    node.next = rightnode;
    rightnode = node

    if(node.right!=null)
        queue.add(node.right)
        queue.add(node.left)
 */
public class Populating_Next_Right_Pointer_In_Each_Node {
    public Node connect(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            Node rightNode = null;
            for(int i=0; i<size; i++){
                Node node = queue.poll();
                node.next = rightNode;
                rightNode = node;
                if(node.right!=null){
                    queue.add(node.right);
                    queue.add(node.left);
                }
            }
        }
        return root;
    }
}
