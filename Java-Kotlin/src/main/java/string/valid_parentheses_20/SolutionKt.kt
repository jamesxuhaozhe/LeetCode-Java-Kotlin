package string.valid_parentheses_20

import java.util.*
import kotlin.collections.HashMap

class SolutionKt {

    fun isValid(s: String): Boolean {
        val map = HashMap<Char, Char>()
        map[')'] = '('
        map['}'] = '{'
        map[']'] = '['

        val stack = Stack<Char>()
        for (char in s.toCharArray()) {
            if (map.containsKey(char)) {
                var topElement = if (stack.isEmpty()) '*' else stack.pop()
                if (topElement != map[char]) {
                    return false
                }
            } else {
                stack.push(char)
            }
        }

        return stack.isEmpty()
    }
}