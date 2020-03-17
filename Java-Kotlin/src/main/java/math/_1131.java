package math;

public class _1131 {

    public int maxAbsValExpr(int[] arr1, int[] arr2) {

        int maxA = Integer.MIN_VALUE;
        int minA = Integer.MAX_VALUE;

        int maxB = Integer.MIN_VALUE;
        int minB = Integer.MAX_VALUE;

        int maxC = Integer.MIN_VALUE;
        int minC = Integer.MAX_VALUE;

        int maxD = Integer.MIN_VALUE;
        int minD = Integer.MAX_VALUE;

        for (int i = 0; i < arr1.length; i++) {
            int A = arr1[i] + arr2[i] + i;
            maxA = Math.max(maxA, A);
            minA = Math.min(minA, A);

            int B = arr1[i] + arr2[i] - i;
            maxB = Math.max(maxB, B);
            minB = Math.min(minB, B);

            int C = arr1[i] - arr2[i] + i;
            maxC = Math.max(maxC, C);
            minC = Math.min(minC, C);

            int D = arr1[i] - arr2[i] - i;
            maxD = Math.max(maxD, D);
            minD = Math.min(minD, D);
        }


        return Math.max(Math.max(Math.max(maxA - minA, maxB - minB), maxC - minC), maxD - minD);
    }
}
