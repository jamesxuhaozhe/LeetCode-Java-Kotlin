package dynamic_programming;

public class _1025 {

    /**
     * 基本思路：
     * <p>
     * 最终结果应该是占到 2 的赢，占到 1 的输；
     * <p>
     * 若当前为奇数，奇数的约数只能是奇数或者 1，因此下一个一定是偶数；
     * <p>
     * 若当前为偶数， 偶数的约数可以是奇数可以是偶数也可以是 1，因此直接减 1，则下一个是奇数；
     * <p>
     * 因此，奇则输，偶则赢。直接:
     *
     * @param N
     * @return
     */
    public boolean divisorGame(int N) {
        return (N & 1) != 1;
    }
}
