package array.fibonacci_number_509;

import array.Solution;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution_test {

    @Test
    public void testFib() {
        Assert.assertEquals(0, new Solution().fib(0));
        assertEquals(1, new Solution().fib(1));
        assertEquals(1, new Solution().fib(2));
        assertEquals(2, new Solution().fib(3));
    }
}
