package jianzhi;

import java.util.Arrays;
import java.util.TreeSet;

public class jz45 {

    // solution is from jianzhi offer book
    public boolean IsContinuous(int [] nums) {
        // 1.数组是null或者数组长度不是5这两种情况显然不用考虑。
        // 2. 先进行排序
        // 3. 统计数组中0的个数
        // 4. 然后统计排序树组中非0元素相邻之间的空缺总数，在这个过程中，要看是否有重复的数字，也就是对子
        // 5. 因为我们要用0去填补空缺，所以0的个数一定要 大于等于 总的空缺数。
        if (nums == null || nums.length != 5) {
            return false;
        }

        // 先进行排序
        Arrays.sort(nums);
        int zeroCount = 0;
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            }
        }

        int gapCount = 0;
        for (int i = zeroCount; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return false;
            }
            gapCount += nums[i + 1] - nums[i] - 1;
        }
        return zeroCount >= gapCount;
    }

    /**
     * 可以这么理解，简单来说就是要是5个数字，最大和最小差值在5以内，并且没有重复数值。用一个set来填充数据，0不要放进去。set的大小加上0的个数必须为5个。此外set中数值差值在5以内.
     * @param nums
     * @return
     */
    public boolean IsContinuous_2(int [] nums) {
        if (nums == null || nums.length != 5) {
            return false;
        }

        int zeroCount = 0;
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            } else {
                set.add(num);
            }
        }

        if (set.size() + zeroCount != 5) {
            return false;
        }

        return Math.abs(set.first() - set.last()) < 5;
    }
}
