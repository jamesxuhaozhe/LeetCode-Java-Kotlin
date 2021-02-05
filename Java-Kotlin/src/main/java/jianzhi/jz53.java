package jianzhi;

public class jz53 {

    public boolean isNumeric(char[] str) {

        if (str == null || str.length == 0)
            return false;
        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }
}
