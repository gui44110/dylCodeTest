package com.dyl.code.leetcode.tanxin;


import java.util.Arrays;

/**
 * @Classname TanXinDemo
 * @Date 28.10.20 9:52 下午
 * @Created by dongyuliang
 */
public class TanXinDemo {

    /**
     * 455
     * https://leetcode-cn.com/problems/assign-cookies/
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = g.length - 1;
        int j = s.length - 1;
        int res = 0;
        while (i > -1 && j > -1 ){
            if(s[j] >= g[i]){
                j--;
                i--;
                res++;
            }else {
                i--;
            }
        }
        return res;
    }

}
