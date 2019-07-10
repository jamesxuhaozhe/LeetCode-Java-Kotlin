package string

class UniqueMorseCodeWordsKt {

    companion object {
        val MORSE_CODE_TABLE = arrayOf(".-", "-...", "-.-.", "-..", ".", "..-.",
            "--.", "....", "..", ".---", "-.-", ".-..",
            "--", "-.", "---", ".--.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--..")
    }

    fun uniqueMorseRepresentations(words: Array<String>): Int {
        if (words.isEmpty()) {
            return 0
        }
        val set = HashSet<String>()
        for (word in words) {
            val charArray = word.toCharArray()
            val sb = StringBuilder()
            for (char in charArray) {
                sb.append(MORSE_CODE_TABLE[char - 'a'])
            }
            set.add(sb.toString())
        }
        return set.size
    }
}