package leetcode;

public class RomanToInteger13 {
    public int romanToInt(String s) {
        int ans = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                ans += eval(s.charAt(i));
                break;
            }
            if (eval(s.charAt(i)) >= eval(s.charAt(i + 1))) ans += eval(s.charAt(i));
            else ans -= eval(s.charAt(i));
        }
        return ans;
    }


    static int eval(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return -1;
    }

}
