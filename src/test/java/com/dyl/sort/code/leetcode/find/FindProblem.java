package com.dyl.sort.code.leetcode.find;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Classname FindProblem
 * @Date 17.11.20 9:16 下午
 * @Created by dongyuliang
 */
public class FindProblem {

    /**
     * 349
     * 给定两个数组，编写一个函数来计算它们的交集。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出：[2]
     * 示例 2：
     *
     * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出：[9,4]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0,index2=0,index3=0;
        int min = Math.min(nums1.length, nums2.length);
        int[] result = new int[min];
        while (index1 <nums1.length && index2 < nums2.length){
            if(nums1[index1] == nums2[index2]){
                if(index3 == 0 || result[index3 - 1] != nums1[index1]){
                    result[index3 ++] = nums1[index1];
                }
                index1 ++;
                index2 ++;
            }else if(nums1[index1] < nums2[index2]){
                index1 ++;
            }else {
                index2 ++;
            }
        }
        return Arrays.copyOfRange(result,0,index3);
    }


    /**
     * 242. 有效的字母异位词
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     *
     * 示例 1:
     *
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * 示例 2:
     *
     * 输入: s = "rat", t = "car"
     * 输出: false
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] count = new int[26];
        for(int i = 0 ;i < s.length() ; i++){
            count[s.charAt(i) - 'a'] ++;
            count[t.charAt(i) - 'a'] --;
        }
        for (int i = 0;i<count.length;i++){
            if(count[i] != 0){
                return false;
            }
        }
        return true;
    }

    /**
     * 202. 快乐数
     * 编写一个算法来判断一个数 n 是不是快乐数。
     *
     * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
     *
     * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        Set<Integer> sets = new HashSet<>();
        while (n != 1 && !sets.contains(n)){
            sets.add(n);
            n = reduce(n);
        }
        return n == 1;
    }

    public int reduce(int n){
        int result = 0;
        while(n > 0){
            int d = n%10;
            result += d*d;
            n = n/10;
        }
        return result;
    }

    /**
     * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
     *
     * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
     *
     * 示例1:
     *
     * 输入: pattern = "abba", str = "dog cat cat dog"
     * 输出: true
     * 示例 2:
     *
     * 输入:pattern = "abba", str = "dog cat cat fish"
     * 输出: false
     * 示例 3:
     *
     * 输入: pattern = "aaaa", str = "dog cat cat dog"
     * 输出: false
     * 示例 4:
     *
     * 输入: pattern = "abba", str = "dog dog dog dog"
     * 输出: false
     * 说明:
     * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/word-pattern
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param pattern
     * @param s
     * @return
     */
    public boolean wordPattern(String pattern, String s) {
        String[] s1 = s.split(" ");
        if(pattern.length() != s1.length){
            return false;
        }
        Map<Character,String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for(int i = 0 ;i < s1.length;i++){
            char c = pattern.charAt(i);
            String s2 = s1[i];
            if(!map.containsKey(c)){
                if(set.contains(s2)){
                    return false;
                }
                map.put(c,s2);
                set.add(s2);
            }else {
                String s3 = map.get(c);
                if(!s2.equals(s3)){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 1. 两数之和
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     *
     *
     *
     * 示例:
     *
     * 给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     * 通过次数1,554,158提交次数3,151,106
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ;i < nums.length;i++){
            int d = target - nums[i];
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(d),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }


    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     *
     *  
     *
     * 示例：
     *
     * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     *
     * 满足要求的三元组集合为：
     * [
     *   [-1, 0, 1],
     *   [-1, -1, 2]
     * ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/3sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0 ;i<nums.length - 2; i++){
            if(nums[i] > 0){
                continue;
            }
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            int temp = 0 - nums[i];
            while (left < right){
                int leftRightResult = nums[left] + nums[right];
                if( leftRightResult == temp){
                    List<Integer> lists = new ArrayList();
                    lists.add(nums[i]);
                    lists.add(nums[left]);
                    lists.add(nums[right]);
                    result.add(lists);
                    while (left < right && nums[left] == nums[left + 1]){
                        left ++;
                    }
                    while (left < right && nums[right] == nums[right -1]){
                        right --;
                    }
                    left ++;
                    right --;

                }else if(leftRightResult > temp){
                    right --;
                }else {
                    left ++;
                }
            }
        }
        return result;
    }

    /**
     * 454
     *
     * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
     *
     * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/4sum-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 使用map
     *
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int result = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ;i < A.length ;i++){
            for(int j = 0 ;j < B.length ; j++){
                int i1 = A[i] + B[j];
                map.put(i1,map.getOrDefault(i1,0) + 1);
            }
        }

        for(int i = 0 ; i< C.length;i++){
            for(int j = 0 ;j < D.length ;j++){
                int i1 = 0 - (C[i] + D[j]);
                if(map.containsKey(i1)){
                    result += map.get(i1);
                }
            }
        }
        return result;
    }


    /**
     * 49
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        return null;
    }


    /**
     *
     * @param nums
     * @param k
     * @return 219
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set =new HashSet<>();
        for(int i = 0 ;i<nums.length;i++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
            if(set.size() > k){
                set.remove(i - k);
            }
        }
        return false;
    }
}
