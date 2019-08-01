package array.two_sum_1

class TwoSumKt {

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()
        for ((index, value) in nums.withIndex()) {
            val complement = target - nums[index]
            if (map.containsKey(complement) && (map[complement] != index)) {
                return intArrayOf(index, map[complement]!!)
            }
            map[value] = index
        }
        throw IllegalArgumentException("No solution given the input")
    }
}