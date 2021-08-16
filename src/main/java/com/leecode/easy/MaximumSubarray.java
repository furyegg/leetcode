package com.leecode.easy;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int begin = 0;
        int end = 0;
        int maxSum = nums[0];
        
        for (int i = 1; i < nums.length; ++i) {
        
        }
        
        return maxSum;
    }
    
    public static void main(String[] args) {
        MaximumSubarray app = new MaximumSubarray();
        
        System.out.println(app.maxSubArray(new int[] {2,-2,-2,0,-2,2,2}));
//        System.out.println(app.maxSubArray(new int[] {8,-19,5,-4,20}));
//        System.out.println(app.maxSubArray(new int[] {-1,-2}));
//        System.out.println(app.maxSubArray(new int[] {1,2}));
//        System.out.println(app.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
//        System.out.println(app.maxSubArray(new int[] {1,1,1,1,1,1,-2,3}));
//        System.out.println(app.maxSubArray(new int[] {1,1,1,1,1,1,-8,3}));
    }
}