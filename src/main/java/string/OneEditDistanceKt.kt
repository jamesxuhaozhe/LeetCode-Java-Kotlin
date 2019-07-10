package string

class OneEditDistanceKt {
    fun isOneEditDistance(s: String, t: String): Boolean {
        if (s == t) {
            return false
        }

        if (s.length == t.length) {
            return isOneReplaceDistance(s, t)
        }

        if (s.length + 1 == t.length) {
            return isOneInsertDistance(s, t)
        }

        if (s.length - 1 == t.length) {
            return isOneInsertDistance(t, s)
        }

        return false
    }

    private fun isOneInsertDistance(s: String, t: String): Boolean {
        var index1 = 0
        var index2 = 0
        while (index1 < s.length && index2 < t.length) {
            if (s[index1] != t[index2]) {
                if (index1 != index2) {
                    return false
                }
                index2++
            } else {
                index1++
                index2++
            }
        }
        return true
    }

    private fun isOneReplaceDistance(s: String, t: String): Boolean {
        if (s.length == 1 && s[0] != t[0]) {
            return true
        }
        var foundDifferent = false
        for (index in 0 until s.length) {
            if (s[index] != t[index]) {
                if (foundDifferent) {
                    return false
                }
                foundDifferent = true
            }

        }
        return true
    }
}