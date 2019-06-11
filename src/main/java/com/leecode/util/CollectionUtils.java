package com.leecode.util;

import java.util.HashMap;
import java.util.Map;

public final class CollectionUtils {
    public static <T> Map<T, Integer> toItemIndexMap(T[] nums) {
        Map<T, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], i);
        }
        return map;
    }
    
    private static <T> void print(T[] arr) {
        StringBuilder sb = new StringBuilder();
        for (T e : arr) {
            sb.append(e.toString()).append(",");
        }
        System.out.println(sb.toString());
    }
    
    private static void print(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int e : arr) {
            sb.append(e).append(",");
        }
        System.out.println(sb.toString());
    }
}