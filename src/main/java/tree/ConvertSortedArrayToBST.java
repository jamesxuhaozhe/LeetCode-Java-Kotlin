package tree;

import misc.datastructure.TreeNode;

public class ConvertSortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return createBST(nums, 0, nums.length - 1);
    }

    private TreeNode createBST(int[] nums, int start, int end) {
        if (end < start) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = createBST(nums, start, mid - 1);
        node.right = createBST(nums, mid + 1, end);
        return node;
    }
}
