package tree;

import common.datastructure.TreeNode;

import java.util.*;

public class _102 {

    //BFS solution
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currLevel.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(currLevel);
        }

        return result;
    }

    // DFS
    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>();

        helper(root, result, 0);

        return result;
    }

    private void helper(TreeNode node, List<List<Integer>> result, int level) {
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }

        result.get(level).add(node.val);

        if (node.left != null) {
            helper(node.left, result, level + 1);
        }

        if (node.right != null) {
            helper(node.right, result, level + 1);
        }
    }
}
