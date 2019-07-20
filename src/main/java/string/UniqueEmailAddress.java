package string;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {

    public int numUniqueEmails(String[] emails) {
        if (emails == null || emails.length == 0) {
            return 0;
        }

        Set<String> emailAddresses = new HashSet<>();
        for (String email : emails) {
            String processedEmail = getProcessedEmail(email);
            emailAddresses.add(processedEmail);
        }
        return emailAddresses.size();
    }

    private String getProcessedEmail(String email) {
        int atSplitterIndex = email.indexOf('@');
        String localName = email.substring(0, atSplitterIndex);
        String domainName = email.substring(atSplitterIndex);
        StringBuilder sb = new StringBuilder();
        char[] chars = localName.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '+') {
                break;
            }
            if (chars[i] != '.') {
                sb.append(chars[i]);
            }
        }

        sb.append(domainName);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("ajmesxuhaozhe@email.com".split("@")[0]);

        System.out.println("ajmesxuhaozhe@email.com".split("@")[1]);
        int index = "jamesxuhaozhe@qq.com".indexOf('@');
        System.out.println("jamesxuhaozhe@qq.com".substring(index));
        System.out.println("jamesxuhaozhe@qq.com".substring(0, index));
    }
}
