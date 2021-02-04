package jianzhi;

import java.util.ArrayList;

public class jz41 {

    // see jianzhi book todo: use golang to do it
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        if (sum < 1) {
            return new ArrayList<>();
        }

        int left = 1;
        int right = 2;
        int curSum = left + right;
        int cutPoint = (sum + 1) / 2;

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        while (left < right && right <= cutPoint) {
            if (curSum < sum) {
                right++;
                curSum += right;
            } else if (curSum > sum) {
                curSum -= left;
                left++;
            } else {
                res.add(getRangeList(left, right));
/*                right++;
                curSum += right;*/
                curSum -= left;
                left++;
            }
        }
        return res;
    }

    private ArrayList<Integer> getRangeList(int left, int right) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            result.add(i);
        }
        return result;
    }
}
