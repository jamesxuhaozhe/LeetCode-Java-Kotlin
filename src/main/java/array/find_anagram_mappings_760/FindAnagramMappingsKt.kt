package array.find_anagram_mappings_760

class FindAnagramMappingsKt {
    fun anagramMappings(A: IntArray, B: IntArray): IntArray {
        val map = HashMap<Int, Int>()
        for (index in B.indices) {
            map[B[index]] = index
        }

        val p = IntArray(A.size)
        for (index in A.indices) {
            p[index] = map[A[index]]!!
        }

        return p
    }
}