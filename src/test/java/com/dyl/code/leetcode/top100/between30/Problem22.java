package com.dyl.code.leetcode.top100.between30;

/**
 * @Classname Problem22
 * @Description
 * 题目 33
 * 升序排列的整数数组 nums 在预先未知的某个点上进行了旋转（例如， [0,1,2,4,5,6,7] 经旋转后可能变为 [4,5,6,7,0,1,2] ）。
 *
 * 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 8.2.21 8:22 下午
 * @Created by dongyuliang
 */
public class Problem22 {

    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        if(nums.length == 1){
            return nums[0]==target?0:-1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <=right){
            int mid = (left + right)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[0] <= nums[mid]){
                if(nums[0] <= target && target <nums[mid]){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else {
                if(nums[mid] < target && target <= nums[nums.length - 1]){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
      int[] array = new int[]{4,5,6,7,0,1,2};
      Problem22 problem22 = new Problem22();
      problem22.search(array,0);
    }
}
