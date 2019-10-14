package system_design.tiny_url_535;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Problem link: https://leetcode-cn.com/problems/encode-and-decode-tinyurl/
 */
public class Codec {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private static final int BASE = ALPHABET.length();

    private static final AtomicInteger counter = new AtomicInteger(0);

    private static final String PRE_FIX = "http://tinyurl.com/";

    private static final Map<String, String> TINY_TO_LONG_MAP = new HashMap<>();


    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        counter.incrementAndGet();
        String tinyUrl = fromBase10(counter.get());
        TINY_TO_LONG_MAP.put(tinyUrl, longUrl);
        return PRE_FIX + tinyUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String[] arr = shortUrl.split("/");
        String tinyUrl = arr[arr.length - 1];
        return TINY_TO_LONG_MAP.get(tinyUrl);
    }

    /**
     * Give a base10 integer, return a String hash which is 62 based
     * @param i base10 integer
     * @return a String hash which is 62 based
     */
    private static String fromBase10(int i) {
        StringBuilder sb = new StringBuilder("");
        if (i == 0) {
            return "a";
        }
        while (i > 0) {
            i = fromBase10(i, sb);
        }
        return sb.reverse().toString();
    }

    private static int fromBase10(int i, final StringBuilder sb) {
        int rem = i % BASE;
        sb.append(ALPHABET.charAt(rem));
        return i / BASE;
    }

    /**
     * Transforms the given string hash into a base10 integer
     * @param str string hash in question
     * @return a base10 integer
     */
    private static int toBase10(String str) {
        return toBase10(new StringBuilder(str).reverse().toString().toCharArray());
    }

    private static int toBase10(char[] chars) {
        int n = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            n += toBase10(ALPHABET.indexOf(chars[i]), i);
        }
        return n;
    }

    private static int toBase10(int n, int pow) {
        return n * (int) Math.pow(BASE, pow);
    }
}