package jianzhi;

public class jz67 {

    // see jianzhi offer book
    public int cutRope(int target) {
        if (target < 2) {
            return 0;
        }
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }

        int[] products = new int[target + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        int max = 0;
        for (int i = 4; i <= target; i++) {
            for (int j = 1; j <= i / 2; j++) {
                max = Math.max(max, products[j] * products[i - j]);
                products[i] = max;
            }
        }
        return products[target];
    }
}
