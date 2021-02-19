package com.dyl.sort.code.leetcode.top100.between30;

/**
 * @Classname Problem23
 * @Description
 * 题目 33
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 8.2.21 9:54 下午
 * @Created by dongyuliang
 */
public class Problem23 {

    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1,-1};
        }

        int first = findFirst(nums, target);
        if(first == -1){
            return new int[]{-1,-1};
        }
        int last = findLast(nums, target);
        return new int[]{first,last};
    }

    private int findFirst(int[] nums,int target){
        int left = 0;int right = nums.length - 1;
        while (left < right){
            int mid = (left + right)/2;
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] == target) {
                right = mid;
            }else {
                right = mid - 1;
            }
        }
        if(nums[left] == target){
            return left;
        }
        return -1;
    }

    private int findLast(int[] nums,int target){
        int left = 0;int right = nums.length - 1;
        while (left < right){
            int mid = (left + right +1)/2;
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] == target) {
                left = mid;
            }else {
                right = mid - 1;
            }
        }
        if(nums[left] == target){
            return left;
        }
        return -1;
    }
}
