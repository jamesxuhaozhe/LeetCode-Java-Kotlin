package jianzhi;

import common.datastructure.TreeNode;

import java.util.ArrayList;

public class jz24 {

    private static void dfs(TreeNode node, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, int leftToTarget) {
        if (node == null) {
            return;
        }

        if (node.val > leftToTarget) {
            return;
        }

        list.add(node.val);
        if (node.val == leftToTarget && node.left == null && node.right == null) {
            res.add(new ArrayList<>(list));
        } else {
            dfs(node.left, res, list, leftToTarget - node.val);
            dfs(node.right, res, list, leftToTarget - node.val);
        }
        list.remove(list.size() - 1);
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return new ArrayList<>();
        }

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        dfs(root, res, list, target);
        return res;
    }
}
