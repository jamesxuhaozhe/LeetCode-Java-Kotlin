package array.shortest_distance_to_a_character_821;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

//TODO we can do better
public class Solution {

    public int[] shortestToChar(String S, char C) {
        char[] chars = S.toCharArray();
        int[] result = new int[chars.length];
        List<Integer> cPos = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == C) {
                cPos.add(i);
            }
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == C) {
                result[i] = 0;
            } else {
                final int index = i;
                OptionalInt optionalInt = cPos.stream().mapToInt(number -> Math.abs(number - index)).min();
                if (optionalInt.isPresent()) {
                    result[i] = optionalInt.getAsInt();
                } else {
                    throw new IllegalArgumentException();
                }
            }
        }
        return result;
    }
}
