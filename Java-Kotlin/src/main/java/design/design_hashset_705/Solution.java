package design.design_hashset_705;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private final Map<Integer, Integer> map;

    /** Initialize your data structure here. */
    public Solution() {
        this.map = new HashMap<>();
    }

    public void add(int key) {
        map.put(key, 0);
    }

    public void remove(int key) {
        if (map.containsKey(key)) {
            map.remove(key);
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return map.containsKey(key);
    }
}
