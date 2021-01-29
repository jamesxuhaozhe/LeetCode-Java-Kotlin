package nowcoder;

import common.datastructure.TreeNode;

import java.util.ArrayList;

public class nc8 {

    // dfs
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // write code here
        if (root == null) {
            return new ArrayList<>();
        }

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        ArrayList<Integer> list = new ArrayList<>();
        dfs(root, res, list, sum);
        return res;
    }

    private static void dfs(TreeNode node, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, int leftToSum) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null && node.val == leftToSum) {
            list.add(node.val);
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }

        list.add(node.val);
        dfs(node.left, res, list, leftToSum - node.val);
        dfs(node.right, res, list, leftToSum - node.val);
        list.remove(list.size() - 1);
    }
}
