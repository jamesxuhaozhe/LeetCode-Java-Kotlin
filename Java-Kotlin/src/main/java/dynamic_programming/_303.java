package dynamic_programming;

public class _303 {

    //brute force
    static class NumArray {

        private int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
        }

        public int sumRange(int i, int j) {
            int sum = 0;
            for (int start = i; start <= j; start++) {
                sum += nums[start];
            }
            return sum;
        }
    }

    static class NumArray1 {

        private int[] sum;

        public NumArray1(int[] nums) {
            //DP function is essentially sum[k] is the accumulated sum from element 0 to element k - 1, sum[0] = 0
            sum = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                sum[i + 1] = nums[i] + sum[i];
            }
        }

        public int sumRange(int i, int j) {

            // sum from index i to j, is sum[j + 1] - sum[i]
            return sum[j + 1] - sum[i];
        }
    }
}
