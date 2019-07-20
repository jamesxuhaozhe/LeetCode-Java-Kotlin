package array

class ToLowerCaseKt {

    fun toLowerCase(str: String): String {
        val offset = 'A' - 'a'
        val chars = str.toCharArray()
        for (index in chars.indices) {
            if (chars[index] in 'A'..'Z') {
                chars[index] = chars[index] - offset
            }
        }
        return String(chars)
    }
}