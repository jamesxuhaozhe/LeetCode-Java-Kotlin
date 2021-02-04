package jianzhi;

import java.util.LinkedList;
import java.util.List;

public class jz46 {

    // 用链表来模拟， 从jianzhi offer book
    // java中直接使用一个list来模拟，并使用一个索引cur类指向删除的位置，当cur的值为list的size，就让cur到头位置。
    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        List<Integer> list = new LinkedList<>();
        //构建list
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int cur = -1;
        while (list.size() > 1) {
            for (int i = 0; i < m; i++) {
                cur++;
                if (cur == list.size()) {
                    cur = 0;
                }
            }
            list.remove(cur);
            cur--;//cur--的原因，因为新的list中cur指向了下一个元素，为了保证移动m个准确性，所以cur向前移动一位。
        }
        return list.get(0);
    }
}
