package array.shuffle_an_array_384

//import kotlin.random.Random

class SolutionKt(nums: IntArray) {

    private var array = nums

    private var original = nums.clone()


    /** Resets the array to its original configuration and return it. */
    fun reset(): IntArray {
        array = original
        original = original.clone()
        return array
    }

    private fun getCopyArray(): ArrayList<Int>{
        val copyArray = arrayListOf<Int>()
        for (index in 0 until array.size) {
            copyArray.add(array[index])
        }
        return copyArray
    }

    /** Returns a random shuffling of the array. */
    fun shuffle(): IntArray {
        val copyArray = getCopyArray()
        for (index in 0 until array.size) {
            //val removeIdx = Random.nextInt(copyArray.size)
            //array[index] = copyArray[removeIdx]
            //copyArray.removeAt(removeIdx)
        }
        return array
    }

}