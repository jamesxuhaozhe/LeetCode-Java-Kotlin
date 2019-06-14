package String

class JewelsAndStonesKt {

    fun numJewelsInStones(J: String, S: String): Int {
        val types = J.toCharArray()
        val typeSets = HashSet<Int>()
        for (type in types) {
            typeSets.add(type.toInt())
        }
        val stones = S.toCharArray()
        var result = 0
        for (stone in stones) {
            val stoneInt = stone.toInt()
            if (typeSets.contains(stoneInt)) {
                result++
            }
        }
        return result
    }
}