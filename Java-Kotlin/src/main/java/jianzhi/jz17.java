package jianzhi;

import common.datastructure.TreeNode;

/**
 * 思路：
 * 第一步：在树A中找到和树B的节点一样的节点R
 * 第二部：判断树A以R为根节点的子树是不是包含树B一样的结构
 * <p>
 * 摘自书上，思路很清晰了，做一个说明：
 * 第一步其实是对树A进行遍历，遍历的话，你可以选深度遍历，也可以选层次遍历，都ok
 * // 刚开始写的层次遍历，感觉代码稍微有点长，就换成了深度遍历
 */
public class jz17 {

    private static boolean isSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }

        if (root1 == null) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }

        return isSubtree(root1.left, root2.left) && isSubtree(root1.right, root2.right);
    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }

        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2) || isSubtree(root1, root2);
    }
}
