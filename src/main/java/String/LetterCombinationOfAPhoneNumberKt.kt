package String

class LetterCombinationOfAPhoneNumberKt {
    companion object {
        private val KEY_BOARDS = mapOf(
            "2" to listOf("a", "b", "c"),
            "3" to listOf("d", "e", "f"),
            "4" to listOf("g", "h", "i"),
            "5" to listOf("j", "k", "l"),
            "6" to listOf("m", "n", "o"),
            "7" to listOf("p", "q", "r", "s"),
            "8" to listOf("t", "u", "v"),
            "9" to listOf("w", "x", "y", "z")
        )
    }

    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) {
            return emptyList()
        }

        if (digits.length == 1) {
            return KEY_BOARDS[digits[0].toString()]!!
        }

        val digitsLen = digits.length
        val prevCombinations = letterCombinations(digits.substring(0, digitsLen - 1))
        val currentKeys = KEY_BOARDS[digits[digitsLen - 1].toString()]

        val result = arrayListOf<String>()
        for (combination in prevCombinations) {
            for (key in currentKeys!!) {
                result.add(combination.plus(key))
            }
        }
        return result
    }
}