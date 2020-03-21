package array

//TODO: This solution is not good. I need to optimize it.
class _442kt {

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