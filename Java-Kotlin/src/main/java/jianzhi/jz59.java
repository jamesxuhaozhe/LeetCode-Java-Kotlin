package jianzhi;

import common.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class jz59 {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        int count = 0;
        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if (count % 2 == 1) {
                reverse(level);
            }
            result.add(level);
            count++;
        }
        return result;
    }

    private static void reverse(ArrayList<Integer> list) {
        int start = 0;
        int end = list.size() - 1;
        while (start < end) {
            int tmp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, tmp);
            start++;
            end--;
        }
    }
}
