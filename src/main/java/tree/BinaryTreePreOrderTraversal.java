package tree;

import misc.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreePreOrderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        preOrderTraversal(root, result);
        return result;
    }

    private void preOrderTraversal(TreeNode node, List<Integer> result) {
        if (node != null) {
            result.add(node.val);
            preOrderTraversal(node.left, result);
            preOrderTraversal(node.right, result);
        }
    }
}
