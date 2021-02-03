package com.dyl.code.leetcode.top100.between10;
/**
 * @Classname Problem
 * @Description 求字符串的最长回文字符串
 * @Date 29.1.21 3:10 下午
 * @Created by dongyuliang
 */
public class Problem5 {














    public String longestPalindrome(String s) {
        if(s.length() == 1){
            return s;
        }
        boolean[][] result = new boolean[s.length()][s.length()];
        for(int i = 0;i < s.length(); i++){
            result[i][i] = true;
        }
        int begin = 0;
        int length = 0;
        for(int j = 1 ;j < s.length() ;j++){
            for(int i = 0; i< j ;i++){
                if(s.charAt(i) != s.charAt(j)){
                    continue;
                }else {
                    if((j - 1) - (i + 1) + 1 < 2){
                        result[i][j] = true;
                    }else {
                        result[i][j] = result[i+1][j-1];
                    }

                    if(result[i][j]){
                        if(j - i + 1 > length){
                            length = j - i;
                            begin = i;
                        }
                    }
                }
            }
        }
        return s.substring(begin,begin + length + 1);
    }

    public static void main(String[] args) {
        String str = "ac";

        Problem5 problem5 = new Problem5();

        System.out.println(problem5.longestPalindrome(str));

    }


}
