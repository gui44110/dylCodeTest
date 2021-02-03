package com.dyl.code.leetcode.top100.between10;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname Problem1
 * @Description
 * 题目 3
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * @Date 31.1.21 8:46 下午
 * @Created by dongyuliang
 */
public class Problem3 {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = -1;
        int result = 0;
        for(int right = 0;right < s.length() ; right ++){
            if(map.containsKey(s.charAt(right))){
                left = Math.max(left,map.get(s.charAt(right)));
            }
            map.put(s.charAt(right),right);
            result = Math.max(result,right - left);
        }
        return result;
    }
}
