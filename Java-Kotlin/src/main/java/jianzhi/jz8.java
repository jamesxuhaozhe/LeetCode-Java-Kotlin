package jianzhi;

public class jz8 {

    public int JumpFloor(int target) {
        if (target <= 1) {
            return target;
        }
        if (target == 2) {
            return 2;
        }
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    public int JumpFloorBad(int target) {
        if (target <= 1) {
            return target;
        }

        if (target == 2) {
            return 2;
        }

        int a = 1;
        int b = 2;
        int sum = 0;
        for (int i = 2; i < target; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }
}
