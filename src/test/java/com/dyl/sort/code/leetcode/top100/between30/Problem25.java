package com.dyl.sort.code.leetcode.top100.between30;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Problem25
 * @Description
 * 题目 46
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列
 *
 * 解法 ：回溯法
 * @Date 9.2.21 4:34 下午
 * @Created by dongyuliang
 */
public class Problem25 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0){
            return result;
        }
        List<Integer> oneWay = new ArrayList<>();
        boolean[] useArray = new boolean[nums.length];
        dfs(result,oneWay,nums,useArray,0);
        return result;
    }

    private void dfs(List<List<Integer>> result,List<Integer> oneWay,int[] nums,boolean[] useArray,int index){
        if(index == nums.length){
            result.add(new ArrayList<>(oneWay));
            return;
        }

        for (int i = 0;i<nums.length;i++){
            if(!useArray[i]){
                oneWay.add(nums[i]);
                useArray[i] = true;
                dfs(result,oneWay,nums,useArray,index + 1);
                useArray[i] = false;
                oneWay.remove(oneWay.size() - 1);
            }
        }

    }


}
