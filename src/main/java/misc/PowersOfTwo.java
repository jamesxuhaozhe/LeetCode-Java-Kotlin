package misc;

public class PowersOfTwo {

    public int printPowersOfTwo(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            System.out.println(1);
            return 1;
        } else {
            int previous = printPowersOfTwo(n / 2);
            int current = previous * 2;
            System.out.println(current);
            return current;
        }
    }

    public static void main(String[] args) {
        new PowersOfTwo().printPowersOfTwo(100);
    }
}
