package com.dyl.sort.code.leetcode.top100.between10;

/**
 * @Classname Problem7
 * @Description
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 *
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 30.1.21 2:41 下午
 * @Created by dongyuliang
 */
public class Problem7 {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] result = new boolean[m + 1][n + 1];
        result[0][0] = true;
        for(int i = 0 ; i <=m ; i++){
            for(int j = 1 ; j <=n; j++){
                if(p.charAt(j - 1) == '*'){
                    if(result[i][j -2]){
                        result[i][j] = true;
                    }else {
                        if(matches(s,p,i,j-1)){
                            result[i][j] = result[i-1][j];
                        }
                    }

                }else {
                    if(matches(s,p,i,j)){
                        result[i][j] = result[i - 1][j-1];
                    }
                }
            }
        }
        return result[m][n];
    }

    private boolean matches(String s,String p,int i,int j){
        if(i == 0){
            return false;
        }
        if(p.charAt(j - 1) == '.'){
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    public static void main(String[] args) {
        Problem7 problem7 = new Problem7();
        System.out.println(problem7.isMatch("aa","a"));
    }
}
