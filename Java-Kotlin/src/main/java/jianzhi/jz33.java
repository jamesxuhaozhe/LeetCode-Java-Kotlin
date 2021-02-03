package jianzhi;

public class jz33 {

    // see jianzhi offer book
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }

        int[] uglyNums = new int[index];
        uglyNums[0] = 1;
        int nextUglyNumIdx = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        while (nextUglyNumIdx < index) {
            int nextUglyNum = Math.min(uglyNums[p2] * 2, Math.min(uglyNums[p3] * 3, uglyNums[p5] * 5));
            uglyNums[nextUglyNumIdx] = nextUglyNum;
            while (uglyNums[p2] * 2 <= nextUglyNum) {
                p2++;
            }
            while (uglyNums[p3] * 3 <= nextUglyNum) {
                p3++;
            }
            while (uglyNums[p5] * 5 <= nextUglyNum) {
                p5++;
            }
            nextUglyNumIdx++;
        }

        return uglyNums[index - 1];
    }
}
