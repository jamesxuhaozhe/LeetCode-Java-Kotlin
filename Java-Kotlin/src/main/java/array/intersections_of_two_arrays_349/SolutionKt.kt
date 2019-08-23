package array.intersections_of_two_arrays_349

class SolutionKt {

    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        val set1 = HashSet<Int>()
        val set2 = HashSet<Int>()
        for (int in nums1) {
            set1.add(int)
        }
        for (int in nums2) {
            set2.add(int)
        }
        val result = HashSet<Int>()
        result.addAll(set1)
        result.retainAll(set2)
        return result.toIntArray()
    }
}