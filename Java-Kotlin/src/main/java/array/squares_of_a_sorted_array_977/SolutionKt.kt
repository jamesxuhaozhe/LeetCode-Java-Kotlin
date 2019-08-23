package array.squares_of_a_sorted_array_977

import java.util.*

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