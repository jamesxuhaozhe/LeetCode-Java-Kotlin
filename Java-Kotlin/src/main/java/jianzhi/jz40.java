package jianzhi;

public class jz40 {

    // see jianzhi book todo: use golang
    public void FindNumsAppearOnce(int[] array, int[] num1, int[] num2) {
        if (array == null || array.length == 0) {
            return;
        }

        int diff = 0;
        for (int i : array) {
            diff ^= i;
        }

        int index = 1;
        while ((diff & index) == 0) {
            index = index << 1;
        }

        for (int num : array) {
            if ((num & index) == 0) {
                num1[0] ^= num;
            } else {
                num2[0] ^= num;
            }
        }
    }
}
