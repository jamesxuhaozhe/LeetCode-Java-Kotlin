package string._344

class SolutionKt {

    fun reverseString(s: CharArray): Unit {
        if (s.isEmpty()) {
            return
        }

        var i = 0
        var j = s.size - 1
        var middle: Char
        while (i < j) {
            middle = s[j]
            s[j] = s[i]
            s[i] = middle
            i++
            j--
        }
    }
}