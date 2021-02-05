package com.dyl.code.leetcode.top100.between20;

/**
 * @Classname Problem19
 * @Description
 * 题目 26
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 5.2.21 4:10 下午
 * @Created by dongyuliang
 */
public class Problem19 {















    public int removeDuplicates(int[] nums) {
        int result = 0;
        for(int i = 1 ;i < nums.length;i++){
            if(nums[i] != nums[result]){
                result ++;
            }
        }
        return result + 1;
    }
}
