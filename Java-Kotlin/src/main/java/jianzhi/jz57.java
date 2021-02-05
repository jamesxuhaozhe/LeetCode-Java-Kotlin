package jianzhi;

import common.datastructure.TreeLinkNode;

// see jianzhi book and my notes.
public class jz57 {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }

        TreeLinkNode curNode = pNode;
        if (curNode.right != null) {
            curNode = curNode.right;
            while (curNode.left != null) {
                curNode = curNode.left;
            }
            return curNode;
        }

        while (curNode.next != null) {
            TreeLinkNode parent = curNode.next;
            if (parent.left == curNode) {
                return parent;
            }
            curNode = parent;
        }
        return null;
    }
}
