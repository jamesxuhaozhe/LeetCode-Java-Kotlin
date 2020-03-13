package string._1108

class SolutionKt {

    fun defangIPaddr(address: String): String {
        if (address.isEmpty()) {
            return address
        }
        val chars = address.toCharArray()
        val sb = StringBuilder()
        for (char in chars) {
            sb.append(if (char == '.') "[.]" else char)
        }
        return sb.toString()
    }
}