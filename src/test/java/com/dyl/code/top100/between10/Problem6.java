package com.dyl.code.top100.between10;

/**
 * @Classname Problem6
 * 给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 30.1.21 12:33 上午
 * @Created by dongyuliang
 */
public class Problem6 {

    public int reverse(int x) {
        int result = 0;
        int max = Integer.MAX_VALUE % 10;
        int min = Integer.MIN_VALUE % 10;
        while (x != 0){
            int p = x%10;
            if(result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && p > max)){
                return 0;
            }
            if(result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && p < min)){
                return 0;
            }
            result = result * 10 + p;
            x = x/10;
        }
        return result;
    }

    public static void main(String[] args) {
        Problem6 problem6 = new Problem6();
        System.out.println(problem6.reverse(-2147483412));
    }
}
