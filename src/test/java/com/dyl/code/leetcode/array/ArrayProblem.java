package com.dyl.code.leetcode.array;

import com.google.common.collect.Lists;
import org.checkerframework.checker.units.qual.min;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname ArrayProblem
 * @Date 29.10.20 9:54 下午
 * @Created by dongyuliang
 */
public class ArrayProblem {

    /**
     * 283
     * https://leetcode-cn.com/problems/move-zeroes/
     *
     */
    public void moveZeroes(int[] nums) {
        int pre = 0;//使用单指针记录前面不为0的位置,一旦发现有非0，交换位置后指针+1
        for(int i = 0 ;i<nums.length;i++){
            if(nums[i]!=0){
                if(pre != i) {
                    int temp = nums[pre];
                    nums[pre] = nums[i];
                    nums[i] = temp;
                }
                pre++;
            }
        }
    }

    public int removeElement(int[] nums, int val) {
        int pre = 0;
        for(int i = 0 ;i<nums.length;i++){
            if(nums[i] != val){
                if(pre != i){
                    int temp = nums[pre];
                    nums[pre] = nums[i];
                    nums[i] = temp;
                }
                pre ++;
            }
        }
        return pre;
    }

    /**
     * 26
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int pre = 0;
        for(int i = 1 ;i<nums.length;i++){
            if(nums[i] != nums[pre]){
                nums[++pre] = nums[i];
            }
        }
        return pre + 1;
    }

    /**
     * 80
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
     * @param nums
     * @return
     */
    public int removeDuplicates1(int[] nums) {
        int pre = 0;
        int size = 1;
        for(int i = 1;i<nums.length;i++){
            if(nums[pre] != nums[i]){
                nums[++pre] = nums[i];
                size = 1;
            }else{
                if(size < 2){
                    size ++;
                    nums[++pre] = nums[i];
                }
            }
        }
        return pre + 1;
    }


    /**
     * 75
     *
     * https://leetcode-cn.com/problems/sort-colors/
     * @param nums 1,2,0
     */
    public void sortColors(int[] nums) {
        int left  = -1;
        int right = nums.length;
        int i = 0;
        while (i<right){
            if(nums[i] == 0){
                left ++;
                swap(nums,left,i);
                i++;
            }else if(nums[i] == 2) {
                right -- ;
                swap(nums,right,i);
            }else {
                i++;
            }

        }
    }

    public void swap(int nums[],int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    /**
     * 88
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m -1 ,j = n - 1,k = m + n -1;
        while (i >=0 && j>=0){
            if(nums1[i] > nums2[j]){
                nums1[k--] = nums1[i--];
            }else{
                nums1[k--] = nums2[j--];
            }
        }
        if(j >= 0){
            while (j>=0){
                nums1[k--]=nums2[j--];
            }
        }
    }

    /**
     * 215
     * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     * @param nums 使用快速排序的方式
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        while (true){
            int partition = partition(nums, left, right);
            if(partition == k -1){
                return nums[partition];
            }else if(partition > k -1){
                right = partition - 1;
            }else {
                left = partition + 1;
            }
        }

    }

    public int partition(int[] nums,int left ,int right){
        int pivot = nums[left];
        int j = left;
        for(int i = left + 1;i<=right;i++){
            if(nums[i] > pivot){
                j++;
                swap(nums,i,j);
            }
        }
        swap(nums,j,left);
        return j;
    }


    /**
     * 167
     * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
     *
     * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
     *
     * 说明:
     *
     * 返回的下标值（index1 和 index2）不是从零开始的。
     * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
     * 示例:
     *
     * 输入: numbers = [2, 7, 11, 15], target = 9
     * 输出: [1,2]
     * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] result =new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while (left < right){
            int i = numbers[left] + numbers[right];
            if(i == target){
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            }else if(target > i){
                left ++;
            }else {
                right --;
            }
        }
        return result;
    }

    /**
     * 125
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     *
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     *
     * 示例 1:
     *
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: true
     * 示例 2:
     *
     * 输入: "race a car"
     * 输出: false
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-palindrome
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left <= right){
           if(Character.isLetterOrDigit(chars[left]) && Character.isLetterOrDigit(chars[right])){
               if(Character.toLowerCase(chars[left]) != Character.toLowerCase(chars[right])){
                   return false;
                }
               left ++;
               right -- ;
               continue;
            }
           if(!Character.isLetterOrDigit(chars[left])){
               left ++;
           }
           if(!Character.isLetterOrDigit(chars[right])){
               right --;
           }
        }
        return true;
    }

    /**
     * 11. 盛最多水的容器
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right){
            int i = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max,i);
            if(height[left] >= height[right]) {
                left ++;
            }else {
                right -- ;
            }
        }
        return max;
    }

    /**
     * 209. 长度最小的子数组
     * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
     *
     *
     *
     * 示例：
     *
     * 输入：s = 7, nums = [2,3,1,2,4,3]
     * 输出：2
     * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int right = -1;
        int min = nums.length + 1;
        int value = 0;
        while (left < nums.length){
            if(right < nums.length - 1 &&value <= s){
                value += nums[++right];
            }else {
                value -= nums[left++];
            }
            if(value >=s){
                min = Math.min(min,right - left + 1);
            }
        }
        if(min == nums.length + 1){
            return 0;
        }
        return min;
    }

    @Test
    public void test1(){
        int[] a = {3,2,1,5,6,4};
        int kthLargest = findKthLargest(a, 2);
        System.out.println(kthLargest);
    }


    /**
     * N皇后问题
     * https://leetcode-cn.com/problemset/all/?search=%E5%85%AB%E7%9A%87%E5%90%8E
     */
    @Test
    public void solveNQueens() {
        List<List<String>> lists = solveNQueens(8);
        print8QueensResult(lists);

    }

    public List<List<String>> solveNQueens(int  n){
        List<List<String>> result = new ArrayList<>(n);
        int[] array = new int[n];
        Arrays.fill(array,-1);
        reduce(result,array,0,n);
        return result;
    }

    public void reduce(List<List<String>> result,int[] array,int row,int n){
        if(row == n){
            List<String> strings = arrayToList(array);
            result.add(strings);
            return;
        }
        for(int i = 0 ;i<n;i++){
            if(isOk(array,n,row,i)){
                array[row] = i;
                reduce(result,array,row+1,n);
            }
        }

    }

    public List<String> arrayToList(int[] array){
        List<String> result = new ArrayList<>(array.length);
        for(int i = 0;i<array.length;i++){
            StringBuilder stringBuilder = new StringBuilder();
            int i1 = array[i];
            for(int j = 0 ;j<array.length;j++){
                if(j == i1){
                    stringBuilder.append("Q");
                }else {
                    stringBuilder.append(".");
                }
            }
            result.add(stringBuilder.toString());
        }
        return result;
    }

    public boolean isOk(int[] array,int n,int row,int col){
        int left = col - 1,right = col + 1;
        for(int i = row - 1;i>=0;i--){
            if(array[i] == col) return false;
            if(left >= 0){
                if(array[i] == left){
                    return false;
                }
            }

            if(right <=n){
                if(array[i] == right){
                    return false;
                }
            }
            left --;right++;
        }
        return true;
    }

    public void print8QueensResult(List<List<String>> lists){
        for(List<String> list : lists){
            for(String str : list){
                System.out.println(str);
            }
            System.out.println("---------");
        }
    }



}
