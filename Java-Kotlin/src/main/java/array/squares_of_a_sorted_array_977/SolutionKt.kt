package array.squares_of_a_sorted_array_977

import java.util.*

/**
 * Problem link: https://leetcode.com/problems/squares-of-a-sorted-array/
 * <p>
 * SolutionDFS idea: naive idea
 * <p>
 * Time complexity: O(nlog(n))
 * <p>
 * Space complexity: O(n)
 */
class SolutionKt {

    fun sortedSquares(A: IntArray): IntArray {
        val n = A.size
        val result = IntArray(n) // Creates an int array of fixed size n, default elements are all 0
        for (index in A.indices) {
            result[index] = A[index] * A[index]
        }
        Arrays.sort(result)
        return result
    }
}