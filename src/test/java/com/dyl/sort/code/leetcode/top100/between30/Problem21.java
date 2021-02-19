package com.dyl.sort.code.leetcode.top100.between30;

/**
 * @Classname Problem21
 * @Description
 *
 * 题目：31
 *
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 6.2.21 6:41 下午
 * @Created by dongyuliang
 */
public class Problem21 {



    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i>=0 && nums[i] >= nums[i+1]){
            i--;
        }
        if(i >= 0){
            int j = nums.length - 1;
            while (j>i && nums[j] <= nums[i]){
                j--;
            }
            swap(nums,i,j);
        }
        arrayReverse(nums,i+1);
    }

    private void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private void arrayReverse(int[] nums,int start){
        int left = start;
        int right = nums.length - 1;
        while (left<right){
            swap(nums,left,right);
            left ++;
            right --;
        }
    }

    public static void main(String[] args) {
        Problem21 problem21 = new Problem21();
        int[] a = new int[]{5,4,7,5,3,2};
        problem21.nextPermutation(a);
    }
}
