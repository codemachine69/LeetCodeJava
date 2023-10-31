package leetcode;

public class StringToInteger8 {
    public int myAtoi(String s) {
        int i = 0, len = s.length();
        boolean isPositive = true;
        int res = 0;

        if (len == 0) return 0;

        while (i < len && s.charAt(i) == ' ') i++;
        if (i < len && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            isPositive = s.charAt(i) == '+' ? true : false;
            i++;
        }

        while (i < len && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            if (Integer.MAX_VALUE / 10 < res || Integer.MAX_VALUE / 10 == res && digit > 7)
                return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + digit;
            i++;
        }

        return isPositive ? res : -res;
    }
}
