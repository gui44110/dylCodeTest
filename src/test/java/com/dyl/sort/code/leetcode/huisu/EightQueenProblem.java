package com.dyl.sort.code.leetcode.huisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname EightQueenProblem
 * @Description
 *
 *设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。这里的“对角线”指的是所有的对角线，不只是平分整个棋盘的那两条对角线
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/eight-queens-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2.2.21 7:38 下午
 * @Created by dongyuliang
 */
public class EightQueenProblem {
















    private List<List<String>> result = new ArrayList<>();

    private int[] intResult;

    private int total;

    public List<List<String>> solveNQueens(int  n){
        intResult = new int[n];
        Arrays.fill(intResult,-1);
        this.total = n;
        reduce(0);
        return result;
    }

    private void reduce(int n){
        if(n == total){
            result.add(arrayToString());
            return;
        }
        for(int i = 0;i<total;i++){
            if(isOk(n,i)){
                intResult[n] = i;
                reduce(n+1);
            }
        }
    }

    private boolean isOk(int row,int col){
        int left = col - 1,right = col + 1;
        for(int i = row - 1;i>=0 ; i--){
            if(intResult[i] == col){
                return false;
            }
            if(left >=0){
                if(intResult[i] == left){
                    return false;
                }
            }
            if(right < total){
                if(intResult[i] == right){
                    return false;
                }
            }
            left --;
            right ++;
        }
        return true;
    }

    private List<String> arrayToString(){
        List<String> result = new ArrayList<>();
        for(int i = 0 ;i< total ;i++){
            StringBuilder builder = new StringBuilder();
            for(int j = 0 ;j < total ;j++){
                if(intResult[i] == j){
                    builder.append("Q");
                }else {
                    builder.append("*");
                }
            }
            result.add(builder.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        EightQueenProblem eightQueenProblem = new EightQueenProblem();
        List<List<String>> lists = eightQueenProblem.solveNQueens(8);
        System.out.println(11);
    }

}
