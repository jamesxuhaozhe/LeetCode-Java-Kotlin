package array.to_lower_case_709

class SolutionKt {

    fun toLowerCase(str: String): String {
        val offset = 'A' - 'a'
        val chars = str.toCharArray()

        chars.forEachIndexed { index, _ ->
            if (chars[index] in 'A'..'Z') {
                chars[index] = chars[index] - offset
            }
        }
        return String(chars)
    }
}