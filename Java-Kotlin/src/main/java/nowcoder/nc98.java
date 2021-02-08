package nowcoder;

import common.datastructure.TreeNode;

public class nc98 {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(23);
        TreeNode root1_4 = new TreeNode(4);
        TreeNode root1_9 = new TreeNode(9);
        TreeNode root1_56 = new TreeNode(56);
        TreeNode root1_8 = new TreeNode(8);
        TreeNode root1_7 = new TreeNode(7);
        root1.left = root1_4;
        root1.right = root1_9;
        root1_4.left = root1_56;
        root1_4.right = root1_8;
        root1_9.left = root1_7;

        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(8);

        System.out.println(new nc98().isContains(root1, root2));

    }

    public boolean isContains(TreeNode root1, TreeNode root2) {
        // write code here
        StringBuffer res1 = new StringBuffer();
        StringBuffer res2 = new StringBuffer();
        preOrder(root1, res1);
        preOrder(root2, res2);
        System.out.println("res1: " + res1.toString());
        System.out.println("res2: " + res2.toString());
        return res1.toString().contains(res2.toString());
    }

    public void preOrder(TreeNode root, StringBuffer res) {
        if (root == null) {
            return;
        }
        preOrder(root.left, res);
        res.append(root.val);
        preOrder(root.right, res);
    }

    public boolean isContainsRecur(TreeNode root1, TreeNode root2) {
        // write code here
        if (root1 == null) {
            return false;
        }

        return isContainsRecur(root1.left, root2) || isContainsRecur(root1.right, root2) || isSubTree(root1, root2);
    }

    public boolean isSubTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }
        return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
    }
}
