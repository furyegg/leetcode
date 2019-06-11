package com.leecode.easy;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        
        int n = 0;
        int m = 0;
        int count = 0;
        while (n < nums.length) {
            if (nums[n] == val) {
                ++count;
            }
            if (nums[m] == val) {
                if (nums[n] != val) {
                    nums[m] = nums[n];
                    ++m;
                }
            } else {
                if (m != n && nums[n] != val) {
                    nums[m] = nums[n];
                }
                ++m;
            }
            ++n;
        }
        print(nums);
        return nums.length - count;
    }
    
    public static void main(String[] args) {
        RemoveElement app = new RemoveElement();
        System.out.println(app.removeElement(new int[] {4,2,0,2,2,1,4,4,1,4,3,2}, 4));
//        System.out.println(app.removeElement(new int[] {3, 3}, 5));
//        System.out.println(app.removeElement(new int[] {3, 3}, 3));
//        System.out.println(app.removeElement(new int[] {1}, 2));
//        System.out.println(app.removeElement(new int[] {3,2,2,3}, 3));
//        System.out.println(app.removeElement(new int[] {0,1,2,2,3,0,4,2}, 2));
    }
    
    private static void print(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int e : arr) {
            sb.append(e).append(",");
        }
        System.out.println(sb.toString());
    }
}