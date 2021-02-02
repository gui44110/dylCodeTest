package com.dyl.code.top100.between10;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname Problem1
 * @Description
 * 1、
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 31.1.21 8:46 下午
 * @Created by dongyuliang
 */
public class Problem1 {

    /**
     * 通过map记录一个中间结果，实现n的时间复杂度
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length;i++){
            int dump = target - nums[i];
            Integer integer = map.get(dump);
            if(integer != null){
                return new int[]{integer,i};
            }else {
                map.put(nums[i],i);
            }
        }
        return new int[]{};
    }
}
