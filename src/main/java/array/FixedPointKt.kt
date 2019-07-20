package array

class FixedPointKt {

    fun fixedPoint(A: IntArray): Int {
        if (A.isEmpty()) {
            return -1
        }
        for (index in A.indices) {
            if (index == A[index]) {
                return index
            }
        }
        return -1
    }
}