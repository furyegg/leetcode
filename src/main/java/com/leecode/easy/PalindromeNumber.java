package com.leecode.easy;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        return x == reverse(x);
    }
    
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
}