package array.find_all_duplicates_in_an_array_442;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//TODO: This solution is not good. I need to optimize it.
public class Solution {

    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            if (set.contains(num)) {
                result.add(num);
            }
            set.add(num);
        }
        return result;
    }
}
