package design.logger_rate_limitter_359;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private final Map<String, Integer> map;

    public Solution() {
        this.map = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (map.containsKey(message)) {
            int lastPrintTimestamp = map.get(message);
            int delta = timestamp - lastPrintTimestamp;
            if (delta >= 0 && delta < 10) {
                return false;
            } else {
                map.put(message, timestamp);
                return true;
            }
        }

        map.put(message, timestamp);
        return true;
    }
}
