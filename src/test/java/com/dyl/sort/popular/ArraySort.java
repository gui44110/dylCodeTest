package com.dyl.sort.popular;


/**
 * 数组相关的算法题
 *
 *
 * 基本的解决思路，单指针，双指针碰撞，滑动窗口
 */
public class ArraySort {


    /**
     * 将数组中的非零元素按顺序排列到数组的一端（就这么说吧）
     */
    public void sort1(int[] arr){
        int lastIndex = 0;
        for(int i = 0 ;i<arr.length;i++){
            if(arr[i] == 0 && lastIndex !=i){
                swap(arr,lastIndex,i);
            }
        }

    }

    public void swap(int[] arr,int x,int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }


    /**
     *
     * leetcode:80
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     *
     * 示例 1:
     *
     * 给定 nums = [1,1,1,2,2,3],
     *
     * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
     *
     * 你不需要考虑数组中超出新长度后面的元素。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int index = 0;
        int count = 1;
        for(int i = 1;i<nums.length;i++){
            if(nums[index] == nums[i]&&count <2){
                nums[++index] = nums[i];
                count++;
            }
            if(nums[index] != nums[i]){
                nums[++index] = nums[i];
                count = 1;
            }
        }
        return index + 1;
    }


    /**
     *
     * leetcode:75
     * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     *
     * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     *
     * 注意:
     * 不能使用代码库中的排序函数来解决这道题。
     *
     * 示例:
     *
     * 输入: [2,0,2,1,1,0]
     * 输出: [0,0,1,1,2,2]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sort-colors
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     */
    public void sortColors(int[] nums) {
        //使用三路快排的思路
        int zero = -1;
        int two = nums.length;
        int temp;
        for(int i = 0 ; i<two;i++){
            if(nums[i] == 1){
                continue;
            }else if(nums[i] == 0) {
                zero ++;
                temp = nums[zero];
                nums[zero] = nums[i];
                nums[i] = temp;
            }else{
                two --;
                temp = nums[two];
                nums[two] = nums[i];
                nums[i] = temp;
            }
        }
    }

    /**
     * leetcode:251
     * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     *
     * 示例 1:
     *
     * 输入: [3,2,1,5,6,4] 和 k = 2
     * 输出: 5
     * 示例 2:
     *
     * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
     * 输出: 4
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        //可以利用快排的思路
        return 0;
    }

    /**
     * leetcode:
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * 说明：你不能倾斜容器，且 n 的值至少为 2。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/container-with-most-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int min = 0;
        int left = 0;
        int right = height.length - 1;
        int temp;
        while (left<right){
            temp = Math.max(height[left],height[right])*(right - left);
            if(temp>min){
                min = temp;
            }
            if(height[left] >height[right]){
                right -- ;
            }else {
                left ++ ;
            }
        }
        return min;
    }

    /**
     * leetcode:209
     * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
     *
     * 示例: 
     *
     * 输入: s = 7, nums = [2,3,1,2,4,3]
     * 输出: 2
     * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int right = -1;
        int min = nums.length + 1;
        int result = 0;
        while (left < nums.length){
            if(right + 1 < nums.length && result <= s){
                result += nums[++right];
            }else{
                result -= nums[left ++];
            }
            if(result >=s){
                min = Math.min(min,right - left + 1);
            }
        }
        if(min == nums.length +1){
            return 0;
        }
        return min;
    }


    /**
     * leetcode:3
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 示例 1:
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        //使用滑动窗口
        char[] chars = s.toCharArray();
        int left = 0;
        int right = -1;
        int max = 0;
        int[] asc = new int[256];
        while (left < s.length() && right < s.length() - 1){
            if(asc[chars[right + 1]] == 0){
                asc[chars[++right]] = 1;
            }else {
                asc[chars[left ++]] = 0;
            }
            max = Math.max(max,right -left +1);
        }
        return max;
    }

}
