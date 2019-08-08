package string.unique_email_addresses_929

class SolutionKt {

    fun numUniqueEmails(emails: Array<String>): Int {
        if (emails.isEmpty()) {
            return 0
        }
        val uniqueEmails = HashSet<String>()
        for (email in emails) {
            uniqueEmails.add(getProcessedEmail(email))
        }
        return uniqueEmails.size
    }

    private fun getProcessedEmail(email: String): String {
        val atIndex = email.indexOf('@')
        val localName = email.substring(0, atIndex)
        val domainName = email.substring(atIndex)
        val sb = StringBuilder()
        val chars = localName.toCharArray()
        for (char in chars) {
            if (char == '+') {
                break
            }
            if (char != '.') {
                sb.append(char)
            }
        }
        return sb.append(domainName).toString()
    }
}