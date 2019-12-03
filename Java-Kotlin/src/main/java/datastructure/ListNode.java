package datastructure;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        ListNode head = this;
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }

        return sb.toString();
    }
}
