package com.dyl.sort.code.leetcode.top100.between30;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Problem24
 * @Description
 * 题目 39
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 解法:回溯算法
 * @Date 9.2.21 11:48 上午
 * @Created by dongyuliang
 */
public class Problem24 {



    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> oneWay = new ArrayList<>();
        dfs(result,oneWay,candidates,target,0);
        return result;
    }

    private void dfs(List<List<Integer>> result ,List<Integer> oneWay,int[] candidates,int target,int index){
        if(target < 0){
            return;
        }
        if( target == 0){
            result.add(new ArrayList<>(oneWay));
            return;
        }

        for(int i = index;i<candidates.length;i++){
            int tmp = target - candidates[i];
            if(tmp > 0){
                oneWay.add(candidates[i]);
                dfs(result,oneWay,candidates,tmp,i);
                oneWay.remove(oneWay.size() - 1);
            }
        }

    }
}
