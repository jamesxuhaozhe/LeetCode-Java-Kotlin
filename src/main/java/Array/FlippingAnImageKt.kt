package Array

class FlippingAnImageKt {
    fun flipAndInvertImage(A: Array<IntArray>): Array<IntArray> {
        if (A.isEmpty()) {
            return A
        }

        val outerSize = A.size
        for (array in A) {
            processArray(array)
        }
        return A
    }

    private fun processArray(array: IntArray) {
        if (array.isEmpty()) {
            return
        }
        var i = 0;
        var j = array.size - 1
        while (i < j) {
            val middle = array[j]
            array[j] = array[i]
            array[i] = middle
            i++
            j--
        }

        for (index in array.indices) {
            array[index] = array[index].reverse()
        }
    }

    private fun reverseInt(number: Int): Int {
        if (number == 0) {
            return 1
        }
        return 0
    }

    fun Int.reverse(): Int = if (this == 0) 1 else 0
}