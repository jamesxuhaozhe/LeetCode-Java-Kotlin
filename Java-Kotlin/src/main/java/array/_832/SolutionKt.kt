package array._832

class SolutionKt {

    fun flipAndInvertImage(A: Array<IntArray>): Array<IntArray> {
        if (A.isEmpty()) {
            return A
        }

        for (array in A) {
            processArray(array)
        }
        return A
    }

    private fun processArray(array: IntArray) {
        if (array.isEmpty()) {
            return
        }
        var i = 0
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

    private fun Int.reverse(): Int = if (this == 0) 1 else 0
}