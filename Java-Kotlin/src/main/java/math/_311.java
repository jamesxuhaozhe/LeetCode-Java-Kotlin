package math;

import java.util.ArrayList;
import java.util.List;

public class _311 {

    /**
     * Based on the matrix multiplication rule. it is still though, ideally
     * we should leverage the fact that the matrix is sparse
     * @param A
     * @param B
     * @return
     */
    public int[][] multiply(int[][] A, int[][] B) {
        int ma = A.length;
        int na = A[0].length;

        int mb = B.length;
        int nb = B[0].length;

        int[][] result = new int[ma][nb];
        for (int i = 0; i < ma; i++) {
            for (int j = 0; j < nb; j++) {
                int curValue = 0;
                for (int k = 0; k < mb; k++) {
                    curValue += A[i][k] * B[k][j];
                }
                result[i][j] = curValue;
            }
        }

        return result;
    }

    public int[][] multiply1(int[][] A, int[][] B) {
        //每个list的元素都是一个list，list是i行不为零元素的下标
        List<List<Integer>> listA = new ArrayList<>();
        int ma = A.length;
        int na = A[0].length;
        for (int i = 0; i < ma; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < na; j++) {
                if (A[i][j] != 0) {
                    list.add(j);
                }
            }
            listA.add(list);
        }

        //每个list的元素都是一个list，list是j列，不为0元素的下标
        List<List<Integer>> listB = new ArrayList<>();
        int mb = B.length;
        int nb = B[0].length;
        for (int i = 0; i < nb; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < mb; j++) {
                if (B[j][i] != 0) {
                    list.add(j);
                }
            }
            listB.add(list);
        }

        int[][] result = new int[ma][nb];
        for (int i = 0; i < ma; i++) {
            for (int j = 0; j < nb; j++) {
                int cur = 0;
                //双指针
                int pos1 = 0, pos2 = 0;
                while (pos1 < listA.get(i).size() && pos2 < listB.get(j).size()) {
                    if (listA.get(i).get(pos1).equals(listB.get(j).get(pos2))) {
                        cur += A[i][listA.get(i).get(pos1)] * B[listB.get(j).get(pos2)][j];
                        pos1++;
                        pos2++;
                    } else if (listA.get(i).get(pos1) < (listB.get(j).get(pos2))) {
                        pos1++;
                    } else {
                        pos2++;
                    }
                }
                result[i][j] = cur;
            }
        }
        return result;
    }
}
