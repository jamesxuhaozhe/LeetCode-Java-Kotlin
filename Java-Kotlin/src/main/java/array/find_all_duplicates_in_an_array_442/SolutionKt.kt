package array.find_all_duplicates_in_an_array_442

//TODO: This solution is not good. I need to optimize it.
class SolutionKt {

    fun findDuplicates(nums: IntArray): List<Int> {
        val set = HashSet<Int>()
        val result = mutableListOf<Int>()
        nums.forEach {
            if (set.contains(it)) {
                result.add(it)
            }
            set.add(it)
        }

        return result
    }
}