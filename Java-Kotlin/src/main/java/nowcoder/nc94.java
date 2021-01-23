package nowcoder;

import java.util.*;

public class nc94 {

    // todo: use golang to solve this problem
    public int[] LFU(int[][] operators, int k) {
        // write code here
        LFUCache lfuCache = new LFUCache(k);
        List<Integer> list = new ArrayList<>();
        for (int[] operator : operators) {
            if (operator.length == 3) {
                lfuCache.put(operator[1], operator[2]);
            } else {
                list.add(lfuCache.get(operator[1]));
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private static class LFUCache {
        private final Map<Integer, Integer> keyToVal;
        private final Map<Integer, Integer> keyToFreq;
        private final Map<Integer, LinkedHashSet<Integer>> freqToKeys;
        private int minFreq;
        private int capacity;

        private LFUCache(int capacity) {
            this.keyToVal = new HashMap<>();
            this.keyToFreq = new HashMap<>();
            this.freqToKeys = new HashMap<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!keyToVal.containsKey(key)) {
                return -1;
            }
            increaseFreq(key);
            return keyToVal.get(key);
        }

        public void put(int key, int value) {
            if (capacity <= 0) {
                return;
            }
            if (keyToVal.containsKey(key)) {
                keyToVal.put(key, value);
                increaseFreq(key);
                return;
            }

            if (keyToVal.size() >= capacity) {
                ensureSize();
            }

            keyToVal.put(key, value);
            keyToFreq.put(key, 1);
            freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
            freqToKeys.get(1).add(key);
            this.minFreq = 1;
        }

        private void increaseFreq(int key) {
            int oldFreq = keyToFreq.get(key);
            keyToFreq.put(key, oldFreq + 1);
            freqToKeys.get(oldFreq).remove(key);
            if (freqToKeys.get(oldFreq).isEmpty()) {
                freqToKeys.remove(oldFreq);
                if (oldFreq == minFreq) {
                    minFreq++;
                }
            }
            freqToKeys.putIfAbsent(oldFreq + 1, new LinkedHashSet<>());
            freqToKeys.get(oldFreq + 1).add(key);
        }

        private void ensureSize() {
            Set<Integer> keySet = freqToKeys.get(minFreq);
            int keyToDelete = keySet.iterator().next();
            keySet.remove(keyToDelete);
            if (keySet.isEmpty()) {
                freqToKeys.remove(minFreq);
            }
            keyToVal.remove(keyToDelete);
            keyToFreq.remove(keyToDelete);
        }
    }
}
