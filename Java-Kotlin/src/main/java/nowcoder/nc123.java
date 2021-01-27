package nowcoder;

import common.datastructure.TreeNode;

import java.util.LinkedList;

// on blue book
public class nc123 {

    private static final String NULL = "#";

    private static final String SEP = "!";

    String Serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }

        sb.append(root.val).append(SEP);

        serialize(root.left, sb);
        serialize(root.right, sb);
    }


    TreeNode Deserialize(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }

        String[] nodes = str.split(SEP);
        LinkedList<String> list = new LinkedList<>();
        for (String s : nodes) {
            list.addLast(s);
        }

        return deserialize(list);
    }

    private TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }

        String first = nodes.removeFirst();
        if (first.equals(NULL)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);

        return root;
    }
}
