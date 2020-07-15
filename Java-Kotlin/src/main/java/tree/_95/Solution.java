package tree._95;

import common.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem link: https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 *
 * 所以如果求 1...n 的所有可能。
 *
 * 我们只需要把 1 作为根节点，[ ] 空作为左子树，[ 2 ... n ] 的所有可能作为右子树。
 *
 * 2 作为根节点，[ 1 ] 作为左子树，[ 3...n ] 的所有可能作为右子树。
 *
 * 3 作为根节点，[ 1 2 ] 的所有可能作为左子树，[ 4 ... n ] 的所有可能作为右子树，然后左子树和右子树两两组合。
 *
 * 4 作为根节点，[ 1 2 3 ] 的所有可能作为左子树，[ 5 ... n ] 的所有可能作为右子树，然后左子树和右子树两两组合。
 *
 * ...
 *
 * n 作为根节点，[ 1... n ] 的所有可能作为左子树，[ ] 作为右子树。
 *
 * 至于，[ 2 ... n ] 的所有可能以及 [ 4 ... n ] 以及其他情况的所有可能，可以利用上边的方法，把每个数字作为根节点，然后把所有可能的左子树和右子树组合起来即可。
 *
 * 如果只有一个数字，那么所有可能就是一种情况，把该数字作为一棵树。而如果是 [ ]，那就返回 null。
 *
 *
 * Reference：https://leetcode-cn.com/problems/unique-binary-search-trees-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-2-7/
 */
public class Solution {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        return helper(1, n);
    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> result = new ArrayList<>();

        //there is no number，add null to result
        if (start > end) {
            result.add(null);
            return result;
        }
        //only one number，add the only number to the result
        if (start == end) {
            result.add(new TreeNode(start));
            return result;
        }

        //尝试每个数字作为根节点
        for (int i = start; i <= end; i++) {
            //得到所有可能的左子树
            List<TreeNode> leftTrees = helper(start, i - 1);
            //得到所有可能的右子树
            List<TreeNode> rightTrees = helper(i + 1, end);
            //左子树右子树两两组合
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    //加入到最终结果中
                    result.add(root);
                }
            }
        }
        return result;
    }
}
