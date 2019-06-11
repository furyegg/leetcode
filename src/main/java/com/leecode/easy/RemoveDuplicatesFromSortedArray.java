package com.leecode.easy;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int endIndex = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != nums[endIndex]) {
                ++endIndex;
                nums[endIndex] = nums[i];
            }
        }
        return ++endIndex;
    }
    
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray app = new RemoveDuplicatesFromSortedArray();
        System.out.println(app.removeDuplicates(new int[] {1,1,2}));
        System.out.println(app.removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4}));
    }
}