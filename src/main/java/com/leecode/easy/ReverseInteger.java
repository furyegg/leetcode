package com.leecode.easy;

public class ReverseInteger {
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        
        int res = 0;
        int n = x;
        while (n != 0) {
            int last = n % 10;
            if (last > 0 && res > (Integer.MAX_VALUE - last) / 10) {
                return 0;
            }
            if (last < 0 && res < (Integer.MIN_VALUE - last) / 10) {
                return 0;
            }
            res = res * 10 + last;
            n /= 10;
        }
        return res;
    }
    
    public int reverse2(int x) {
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        char[] reversedChars = reverseChars(chars);
        try {
            return Integer.valueOf(String.valueOf(reversedChars));
        } catch (Exception e) {
            return 0;
        }
    }
    
    private char[] reverseChars(char[] chars) {
        if (chars[0] == '-') {
            return reverseChars(chars, 1, chars.length - 1);
        } else {
            return reverseChars(chars, 0, chars.length - 1);
        }
    }
    
    private char[] reverseChars(char[] chars, int start, int end) {
        if (end - start == 0) {
            return chars;
        }
        int s = start;
        int e = end;
        while (s < e) {
            swap(chars, s, e);
            ++s;
            --e;
        }
        return chars;
    }
    
    private void swap(char[] chars, int s, int e) {
        char t = chars[s];
        chars[s] = chars[e];
        chars[e] = t;
    }
    
    public static void main(String[] args) {
        ReverseInteger app = new ReverseInteger();
        System.out.println(app.reverse(1534236469));
        System.out.println(app.reverse(123));
        System.out.println(app.reverse(-123));
        System.out.println(app.reverse(120));
        System.out.println(app.reverse(3));
        System.out.println(app.reverse(45));
    }
}