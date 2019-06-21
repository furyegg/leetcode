package com.leecode.easy;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int sum = maxSum;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > maxSum) {
                maxSum = sum < 0 ? nums[i] : sum + nums[i];
                sum = maxSum;
            } else {
                int s = sum + nums[i];
                sum = s < 0 ? nums[i] : s;
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }
    
    public static void main(String[] args) {
        MaximumSubarray app = new MaximumSubarray();
        System.out.println(app.maxSubArray(new int[] {2,-2,-2,0,-2,2,2}));
        System.out.println(app.maxSubArray(new int[] {8,-19,5,-4,20}));
        System.out.println(app.maxSubArray(new int[] {-1,-2}));
        System.out.println(app.maxSubArray(new int[] {1,2}));
        System.out.println(app.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(app.maxSubArray(new int[] {1,1,1,1,1,1,-2,3}));
        System.out.println(app.maxSubArray(new int[] {1,1,1,1,1,1,-8,3}));
    }
}