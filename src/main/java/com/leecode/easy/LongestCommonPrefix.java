package com.leecode.easy;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLen = strs[0].length();
        for (int i = 1; i < strs.length; ++i) {
            minLen = Math.min(minLen, strs[i].length());
        }
        if (minLen == 0) {
            return "";
        }
        
        StringBuilder res = new StringBuilder();
        
        for (int i = 0; i < minLen; ++i) {
            char c = strs[0].charAt(i);
            boolean needBreak = false;
            for (int j = 1; j < strs.length; ++j) {
                if (strs[j].charAt(i) != c) {
                    needBreak = true;
                    break;
                }
            }
            if (needBreak) {
                break;
            }
            res.append(c);
        }
        return res.toString();
    }
    
    public static void main(String[] args) {
        LongestCommonPrefix app = new LongestCommonPrefix();
        System.out.println(app.longestCommonPrefix(new String[]{"aca", "cba"}));
        System.out.println(app.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(app.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }
}