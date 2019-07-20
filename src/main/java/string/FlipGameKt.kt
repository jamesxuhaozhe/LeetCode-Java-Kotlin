package string

class FlipGameKt {

    fun generatePossibleNextMoves(s: String): List<String> {
        if (s.isEmpty() || s.length == 1) {
            return emptyList()
        }

        val chars = s.toCharArray()
        val result = arrayListOf<String>()
        for (index in 0 until chars.size - 1) {
            if (chars[index] == '+' && chars[index + 1] == '+') {
                chars[index] = '-'
                chars[index + 1] = '-'
                result.add(String(chars))
                chars[index] = '+'
                chars[index + 1] = '+'
            }
        }
        return result
    }
}