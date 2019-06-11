package com.leecode.easy;

public class RomanToInteger {
    
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < chars.length; ++i) {
            char current = chars[i];
            int currentValue = getValue(current);
            boolean hasNext = i < chars.length - 1;
            int item = currentValue;
            if (hasNext) {
                char next = chars[i + 1];
                int nextValue = getValue(next);
                if (currentValue < nextValue) {
                    item = nextValue - currentValue;
                    ++i;
                }
            }
            sum += item;
        }
        return sum;
    }
    
    private int getValue(char c) {
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
        return 0;
    }
    
    public static void main(String[] args) {
        RomanToInteger app = new RomanToInteger();
        System.out.println(app.romanToInt("III"));
        System.out.println(app.romanToInt("IV"));
        System.out.println(app.romanToInt("IX"));
        System.out.println(app.romanToInt("LVIII"));
    }
}