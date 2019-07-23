package array;

import java.util.ArrayList;
import java.util.List;

//TODO we can do better
public class ShortestDistanceToACharacter {
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
                result[i] = cPos.stream().mapToInt(number -> Math.abs(number - index)).min().getAsInt();
            }
        }
        return result;
    }
}
