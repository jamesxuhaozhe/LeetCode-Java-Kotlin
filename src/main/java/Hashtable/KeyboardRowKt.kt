package Hashtable

class KeyboardRowKt {
    companion object {
        val ROWS = arrayOf("qwertyuiop", "asdfghjkl", "zxcvbnm")
    }
    fun findWords(words: Array<String>): Array<String> {
        if (words.isEmpty()) {
            return words
        }
        val results = arrayListOf<String>()
        for (word in words) {
            if (isValidWord(word.toLowerCase())) {
                results.add(word)
            }
        }
        return results.toTypedArray()
    }

    private fun isValidWord(word: String): Boolean {
        var isValid = true
        var applicableRow: String? = null
        val chars = word.toCharArray()

        for (row in ROWS) {
            if (row.indexOf(chars[0]) > -1) {
                applicableRow = row
                break
            }
        }

        if (applicableRow == null) {
            isValid = false
            return isValid
        }

        for (index in 1 until chars.size) {
            if (applicableRow.indexOf(chars[index]) == -1) {
                isValid = false
                return isValid
            }
        }
        return isValid
    }
}