package nowcoder;

import java.util.Arrays;

public class nc30 {

    public int minNumberdisappered(int[] arr) {
        // write code here
        // write code here
        if (arr.length == 0) {
            return 0;
        }
        int i = 1;           //初始化最小正整数
        Arrays.sort(arr);  //将数组排序
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] <= 0) {
                continue;       //如果小于等于0则继续循环
            } else if (arr[j] <= i) {
                i++;        //如果小于等于i则i++
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 2, 3, 4};

        System.out.println(new nc30().minNumberdisappered(arr));
    }
}
