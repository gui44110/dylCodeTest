package com.dyl.code.leetcode.top100.between20;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Problem17
 * @Description
 * 题目 22
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *
 * 思路：使用回溯算法
 * 判断条件
 * 1、（ 的数量小于 n时，就可以放 （
 * 2、 ）的数量数量小于（时，就可以放）
 * 3、注意执行完一次之后，需要删除新增的字段，保证可以重新计算
 * @Date 4.2.21 6:17 下午
 * @Created by dongyuliang
 */
public class Problem17 {



























    private List<String> result;

    private int n;

    public List<String> generateParenthesis(int n) {
        this.result = new ArrayList<>();
        this.n = n;
        if(n == 0){
            return result;
        }
        reduce(0,0,new StringBuilder());
        return result;
    }

    private void reduce(int open,int close,StringBuilder stringBuilder){

        if(stringBuilder.length() == n * 2){
            result.add(stringBuilder.toString());
            return;
        }

        if(open < n){
            stringBuilder.append('(');
            reduce(open +1,close,stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        if(close < open){
            stringBuilder.append(')');
            reduce(open,close+1,stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
