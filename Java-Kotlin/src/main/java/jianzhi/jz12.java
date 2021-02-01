package jianzhi;

public class jz12 {

    /**
     * https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/solution/fei-di-gui-he-di-gui-de-liang-chong-jie-jue-fang-s/
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }

        if (exponent < 0) {
            return 1 / base * Power(1 / base, -exponent - 1);
        }

        return exponent % 2 == 0 ? Power(base * base, exponent / 2) : base * Power(base * base, exponent / 2);
    }
}
