package array.find_all_duplicates_in_an_array_442

//TODO: This solution is not good. I need to optimize it.
class SolutionKt {

    fun findDuplicates(nums: IntArray): List<Int> {
        val set = HashSet<Int>()
        val result = mutableListOf<Int>()
        for (num in nums) {
            if (set.contains(num)) {
                result.add(num)
            }
            set.add(num)
        }

        return result
    }
}