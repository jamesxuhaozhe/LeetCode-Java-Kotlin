package array.shuffle_an_array_384;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BrutalSolution {

    private int[] array;

    private int[] original;

    private Random random = new Random();

    public BrutalSolution(int[] nums) {
        this.array = nums;
        this.original = nums.clone();
    }

    private List<Integer> getCopyArray() {
        List<Integer> copyArray = new ArrayList<>(array.length);
        for (int i = 0; i < array.length; i++) {
            copyArray.add(array[i]);
        }

        return copyArray;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array = original;
        original = original.clone();
        return array;

    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        List<Integer> aux = getCopyArray();
        for (int i = 0; i < array.length; i++) {
            int removeIdx = random.nextInt(aux.size());
            array[i] = aux.get(removeIdx);
            aux.remove(removeIdx);
        }

        return array;
    }
}
