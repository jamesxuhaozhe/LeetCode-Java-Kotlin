package linkedList._379;

public class PhoneDirectory {

    private int size;

    // store the use of the number, if the number is used, then it will be true, by default it should all be false
    private boolean[] use;

    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        this.size = maxNumbers;
        this.use = new boolean[size];
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        for (int i = 0; i < size; i++) {
            if (!use[i]) {
                use[i] = true;
                return i;
            }
        }
        return -1;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        if (number >= size) {
            throw new IllegalArgumentException();
        }
        return !use[number];
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if (number < size) {
            use[number] = false;
        }
    }
}
