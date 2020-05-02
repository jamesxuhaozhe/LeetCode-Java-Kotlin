package array

//import kotlin.random.Random

class _384kt(nums: IntArray) {

    private var array = nums

    private var original = nums.clone()


    /** Resets the array to its original configuration and return it. */
    fun reset(): IntArray {
        array = original
        original = original.clone()
        return array
    }

    private fun getCopyArray(): ArrayList<Int> {
        val copyArray = arrayListOf<Int>()
        for (element in array) {
            copyArray.add(element)
        }
        return copyArray
    }

    /** Returns a random shuffling of the array. */
    fun shuffle(): IntArray {
        val copyArray = getCopyArray()
        for (index in array.indices) {
            //val removeIdx = Random.nextInt(copyArray.size)
            //array[index] = copyArray[removeIdx]
            //copyArray.removeAt(removeIdx)
        }
        return array
    }

}