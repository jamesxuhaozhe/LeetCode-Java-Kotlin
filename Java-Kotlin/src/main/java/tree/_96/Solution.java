package tree._96;

import common.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;


/**
 * Problem link: https://leetcode-cn.com/problems/unique-binary-search-trees/
 *
 *
 */
public class Solution {

    //Solution pretty much the same as problem 95(stupid solution)
    static class Solution1 {
        public int numTrees(int n) {
            if (n == 0) {
                return 0;
            }

            List<TreeNode> result = helper(1, n);
            return result.size();
        }

        private List<TreeNode> helper(int start, int end) {
            List<TreeNode> result = new ArrayList<>();
            if (start > end) {
                result.add(null);
                return result;
            }

            if (start == end) {
                result.add(new TreeNode(start));
                return result;
            }

            for (int i = start; i <= end; i++) {
                List<TreeNode> leftTrees = helper(start, i - 1);
                List<TreeNode> rightTrees = helper(i + 1, end);
                for (TreeNode leftTree : leftTrees) {
                    for (TreeNode rightTree : rightTrees) {
                        TreeNode root = new TreeNode(i);
                        root.left = leftTree;
                        root.right = rightTree;
                        result.add(root);
                    }
                }
            }
            return result;
        }
    }


}
