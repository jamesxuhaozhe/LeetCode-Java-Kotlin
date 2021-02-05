package jianzhi;

public class jz51 {

    // 看jianzhi offer书，记得要画图
    public int[] multiply(int[] a) {
        if (a == null || a.length <= 1) {
            return a;
        }

        int[] b = new int[a.length];
        b[0] = 1;
        for (int i = 1; i < a.length; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        int tmp = 1;
        for (int i = a.length - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        return b;
    }
}
