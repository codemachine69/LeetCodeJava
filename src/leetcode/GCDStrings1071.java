package leetcode;

public class GCDStrings1071 {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1 + str2).equals(str2 + str1)) return "";
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    int gcd(int x, int y) {
        if(y == 0) return x;
        return gcd(y, x%y);
    }
}
