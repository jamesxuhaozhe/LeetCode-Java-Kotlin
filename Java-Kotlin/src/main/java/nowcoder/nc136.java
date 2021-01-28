package nowcoder;

import common.datastructure.TreeNode;

import java.util.*;

public class nc136 {

    public int[] solve(int[] pre, int[] in) {
        // write code here
        if (pre == null || pre.length == 0 || in == null || in.length == 0 || pre.length != in.length) {
            return new int[]{};
        }

        TreeNode root = buildTree(pre, in);
        return getRightView(root);
    }

    private int[] getRightView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<Integer> list = new ArrayList<>();

        TreeNode tmp = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                tmp = queue.poll();
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }
            list.add(tmp.val);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private TreeNode buildTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                root.left = buildTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                root.right = buildTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
                break;
            }
        }
        return root;
    }
}
