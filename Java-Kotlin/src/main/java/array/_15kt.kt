package array

class _15kt {

    fun threeSum(nums: IntArray): List<List<Int>> {
        if (nums.isEmpty()) {
            return emptyList()
        }

        nums.sort()
        val result: MutableList<MutableList<Int>> = ArrayList()
        for (i in 0 until nums.size - 2) {
            if (i >= 1 && nums[i] == nums[i - 1]) {
                continue
            }

            var left = i + 1
            var right = nums.size - 1
            while (left < right) {
                val sum = nums[i] + nums[left] + nums[right]
                when {
                    sum == 0 -> {
                        result.add(mutableListOf(nums[i], nums[left], nums[right]))
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++
                        }

                        while (left < right && nums[right] == nums[right - 1]) {
                            right--
                        }
                        left++
                        right--
                    }
                    sum > 0 -> {
                        right--
                    }
                    else -> {
                        left++
                    }
                }
            }
        }
        return result
    }
}