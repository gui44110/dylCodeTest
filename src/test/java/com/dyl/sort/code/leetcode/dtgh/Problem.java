package com.dyl.sort.code.leetcode.dtgh;

import org.junit.Test;

/**
 * @Classname Problem
 * @Date 5.12.20 10:39 下午
 * @Created by dongyuliang
 *
 * 动态规划和递归类似，
 * 1、递归是自上而下的解决问题 假设下面的问题已经解决，然后解决最大的问题  递归 + 记忆化搜索
 * 2、动态绘画是自下而上的解决问题，假设最小的问题已经解决，一次解决最大的问题
 *
 * 动态规划
 * 将愿问题拆解成若干子问题，同时保存子问题的答案，使得每个子问题只求解一次，最终获得原问题的答案
 */
public class Problem {

    /**
     * 斐波那契数列
     *
     * 动态规划的解决问题
     * @param n
     * @return
     */
    public int fib(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int[] array = new int[n + 1];
        array[0] = 0;
        array[1] = 1;
        for(int i = 2 ; i<=n; i++){
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }

    @Test
    public void test(){
        System.out.println(fib(3));
    }
}
