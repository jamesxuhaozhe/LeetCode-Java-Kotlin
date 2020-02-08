package array._717;

public class _717 {

    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        // we scan the array, if bit is 1, then it means it is the start of the second character, we should add 2 to i, if i is 0, then add 1 to i
        // at last, we just need to check if i falls at the last element
        while (i < bits.length - 1) {
            i += bits[i] + 1;
        }
        return i == bits.length - 1;
    }
}
