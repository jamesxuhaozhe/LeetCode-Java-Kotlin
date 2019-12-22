package math.check_straight_line_1232;

/**
 * Time complexity: O(n)
 *
 * Space complexity: O(1)
 */
public class Solution {

    public boolean checkStraightLine(int[][] coordinates) {
        int[] initialPoint = coordinates[0];
        int[] secondPoint = coordinates[1];

        int deltaX = secondPoint[0] - initialPoint[0];
        int deltaY = secondPoint[1] - initialPoint[1];

        for (int i = 2; i < coordinates.length; i++) {
            int[] currentPoint = coordinates[i];

            int x = currentPoint[0] - initialPoint[0];
            int y = currentPoint[1] - initialPoint[1];

            if (deltaX * y != deltaY * x) {
                return false;
            }
        }

        return true;
    }
}
