package com.leecode.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = toItemIndexMap(nums);
        for (int i = 0; i < nums.length; ++i) {
            int current = nums[i];
            int diff = target - current;
            Integer result = map.get(diff);
            if (result != null && result != i) {
                return new int[]{i, result};
            }
        }
        return new int[]{-1, -1};
    }
    
    public Map<Integer, Integer> toItemIndexMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], i);
        }
        return map;
    }
    
    public static void main(String[] args) {
        TwoSum app = new TwoSum();
        
        int[] nums1 = new int[]{2, 3, 7, 8, 10};
        int[] result1 = app.twoSum(nums1, 9);
        System.out.println(result1[0] + ", " + result1[1]);
        
        int[] nums2 = new int[]{3, 2, 4};
        int[] result2 = app.twoSum(nums2, 6);
        System.out.println(result2[0] + ", " + result2[1]);
    }
}