package com.leecode.easy;

public class ImplementStr {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty()) {
            return 0;
        }
        
        int index = 0;
        int start = 0;
        int i = start;
        while (i < haystack.length()) {
            if (needle.charAt(index) == haystack.charAt(i)) {
                if (haystack.length() - i < needle.length() - index) {
                    return -1;
                }
                ++index;
                if (index == needle.length()) {
                    return i - index + 1;
                }
                ++i;
            } else {
                index = 0;
                i = ++start;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        ImplementStr app = new ImplementStr();
        System.out.println(app.strStr("mississippi", "issi"));
        System.out.println(app.strStr("mississippi", "issip"));
        System.out.println(app.strStr("mississippi", "issipi"));
        System.out.println(app.strStr("aaa", "aaa"));
        System.out.println(app.strStr("hello", "ll"));
        System.out.println(app.strStr("aaaaa", "ba"));
    }
}