package math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _1131 {

    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        List<Integer> listC = new ArrayList<>();
        List<Integer> listD = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            listA.add(arr1[i] + arr2[i] + i);
            listB.add(arr1[i] + arr2[i] - i);
            listC.add(arr1[i] - arr2[i] + i);
            listD.add(arr1[i] - arr2[i] - i);
        }
        Collections.sort(listA);
        Collections.sort(listB);
        Collections.sort(listC);
        Collections.sort(listD);
        int maxA = listA.get(listA.size() - 1);
        int minA = listA.get(0);

        int maxB = listB.get(listB.size() - 1);
        int minB = listB.get(0);

        int maxC = listC.get(listC.size() - 1);
        int minC = listC.get(0);

        int maxD = listD.get(listD.size() - 1);
        int minD = listD.get(0);

        return Math.max(Math.max(Math.max(maxA - minA, maxB - minB), maxC - minC), maxD - minD);
    }
}
