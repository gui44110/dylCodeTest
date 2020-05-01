package com.dyl.mianshi.sort;

import java.util.List;

/**
 * 动态规划思想解决的算法题
 * 动态规划的思想
 * 将原问题拆解成若干子问题，同时保证子问题的答案，使得每个子问题只求解一次，最终获得原问题的答案
 *
 *                             ------>记忆化搜索（自顶向下的解决思路）
 * 递归问题------>拆解若干子问题
 *                             ------>动态规划（自下向顶的解决思路）
 */
public class DynamicProGram {

    /**
     * 斐波那契数列
     * f(1) = 1,f(0) = 0,f(n) = f(n-1) + f(n-2)
     *
     * 使用递归的思路
     */

    public int f(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return f(n-1) + f(n -2);
    }

    /**
     * 对上述算法优化，通过记忆化搜索都方式，记录已经计算过的值，防止每次都重新计算
     */

    public int sort(int n){
        int[] a = initArray(n);
        return fSort(n,a);
    }
    public int fSort(int n,int[] a){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(a[n] == -1){
            return a[n] = fSort(n-1,a) + fSort(n -2,a);
        }
        return a[n];
    }

    /**
     * 通过动态规划的方式解决，基本思路是由小到大的解决思路
     * @param n
     * @return
     */
    public int dynamicSort(int n){
        int[] a = new int[n+1];
        a[0] = 0;
        a[1] = 1;
        for(int i = 2;i<=n;i++){
            a[n] = a[n-1] + a[n-2];
        }
        return a[n];
    }

    /**
     * 初始化数组
     * @param n
     * @return
     */
    public int[] initArray(int n){
        int[] result = new int[n + 1];
        for(int i = 0 ;i<n;i++){
            result[i] = -1;
        }
        return result;
    }


    /**
     * leetcode:70
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     *
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     *
     * 注意：给定 n 是一个正整数。
     */
    public int climbStairs(int n) {
        int[] arr = initArray(n);
        arr[0] = 1;
        arr[1] = 1;
        for(int i = 2;i<=n;i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }


    /**
     * leetcode:120
     *
     * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
     *
     * 例如，给定三角形：
     *
     * [
     *      [2],
     *     [3,4],
     *    [6,5,7],
     *   [4,1,8,3]
     * ]
     * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/triangle
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param triangle
     * @return
     */

    int row ;
    Integer[][] mem;
    public int minimumTotal1(List<List<Integer>> triangle) {
        //使用递归的自顶向下递归的方式，
        row = triangle.size() - 1;
        mem = new Integer[triangle.size()][triangle.size()];
        return helper(0,0,triangle);
    }

    public int helper(int level,int count,List<List<Integer>> triangle){
        if(level == row){
            return triangle.get(level).get(count);
        }
        if(mem[level][count] != null){
            return mem[level][count];
        }
        int left = helper(level + 1,count,triangle);
        int right = helper(level + 1,count + 1,triangle);
        mem[level][count] = Math.min(left,right) + triangle.get(level).get(count);
        return mem[level][count];
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        int[] a = new int[triangle.size() + 1];
        for(int i = triangle.size() - 1;i>=0;i++){
            for(int j = 0;j<i;j++){
                a[j] = Math.min(a[j],a[j+1]) + triangle.get(i).get(j);
            }
        }
        return a[0];

    }


    /**
     * leetcode:64
     * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     *
     * 说明：每次只能向下或者向右移动一步。
     *
     * 示例:
     *
     * 输入:
     * [
     *   [1,3,1],
     *   [1,5,1],
     *   [4,2,1]
     * ]
     * 输出: 7
     * 解释: 因为路径 1→3→1→1→1 的总和最小。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-path-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        rowNum = grid.length - 1;
        colNum = grid[0].length  - 1;
        arr = new Integer[grid.length][grid.length];
        return helper(0,0,grid);
    }
    int rowNum;
    int colNum;
    Integer[][] arr;
    public int helper(int n,int m,int[][] grid){
        if(arr[n][m] != null){
            return arr[n][m];
        }
        if(m == rowNum && n<colNum){
            arr[n][m] =  helper(m,n+1,grid) + grid[n][m];
        }else if(m <rowNum && n == colNum){
            arr[n][m] =  helper(m+1,n,grid) + grid[n][m];
        }else if(m == rowNum && n == colNum){
            arr[n][m] = grid[n][m];
        }else {
            arr[n][m] = Math.min(helper(m,n+1,grid),helper(m+1,n,grid)) + grid[n][m];
        }
        return arr[n][m];
    }


    /**
     * leetcode:343. 整数拆分
     *给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
     * @param n
     * @return
     */
    public int integerBreak1(int n) {
        num = new Integer[n];
        return integerBreakSort(n);
    }
    Integer [] num;
    public int integerBreakSort(int n){
        if(n == 1){
            return 1;
        }
        if(num[n] != null){
            return num[n];
        }
        int res = -1;
        for(int i = 1;i<n;i++){
            res = max(res,i*(n-1),i*integerBreakSort(n-i));
        }
        num[n] = res;
        return res;
    }

    public int max(int a,int b,int c){
        return Math.max(a,Math.max(b,c));
    }


    public int integerBreak(int n){
        int[] res = new int[n+1];
        res[1] = 1;
        for(int i = 2;i<=n;i++){
            for(int j = 1;j<=i-1;j++){
                res[i] = max(res[i],j*(i-1),j*res[i-j]);
            }
        }
        return res[n];
    }

    /**
     *leetcode:279
     * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
     *
     * 示例 1:
     *
     * 输入: n = 12
     * 输出: 3
     * 解释: 12 = 4 + 4 + 4.
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/perfect-squares
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    public int numSquares(int n) {
//        //使用动态规划的思想
//        int[] arr = new int[n+1];
//        arr[1] = 1;
//        for(int i = 1;i<=n;i++){
//            arr[i] = i;
//            for(int  j = 1;i-j*j>=0;j++){
//                arr[i] = Math.min(arr[i],arr[i-j] + 1);
//            }
//        }
//        return arr[n];
        int[] a = new int[n + 1];
        a[1] = 1;
        for(int i = 2;i<=n;i++){
            a[i] = i;
            for(int j = 1;i - j*j > 0;j++){
                a[i] = Math.min(a[i],a[i-j]+1);
            }
        }
        return a[n];
    }

}
