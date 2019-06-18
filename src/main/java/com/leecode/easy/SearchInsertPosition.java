package com.leecode.easy;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (target < nums[0]) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        return search(nums, 0, nums.length - 1, target);
    }
    
    private int search(int[] nums, int start, int end, int target) {
        if (start == end) {
            return nums[end] > target ? start : end;
        }
        if (start > end) {
            return start;
        }
        int m = (start + end) / 2;
        int mv = nums[m];
        if (mv == target) {
            return m;
        }
        if (mv > target) {
            return search(nums, start, m, target);
        } else {
            return search(nums, m + 1, end, target);
        }
    }
    
    public static void main(String[] args) {
        SearchInsertPosition app = new SearchInsertPosition();
        System.out.println(app.searchInsert(new int[] {1,2,4,6,7}, 3));
        System.out.println(app.searchInsert(new int[] {1,3,5}, 4));
        System.out.println(app.searchInsert(new int[] {5}, 5));
        System.out.println(app.searchInsert(new int[] {5, 6}, 5));
        System.out.println(app.searchInsert(new int[] {1,3,5,6}, 5));
        System.out.println(app.searchInsert(new int[] {1,3,5,6}, 2));
        System.out.println(app.searchInsert(new int[] {1,3,5,6}, 7));
        System.out.println(app.searchInsert(new int[] {1,3,5,6}, 0));
    }
}