package com.dyl.mianshi.sort;


import java.util.Arrays;
import java.util.Comparator;

/**
 * 贪心算法
 */
public class GreedySort {


    /**
     * leetcode:455
     * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
     *
     * 注意：
     *
     * 你可以假设胃口值为正。
     * 一个小朋友最多只能拥有一块饼干。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/assign-cookies
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = s.length - 1 ,j = g.length - 1;
        int count = 0;
        while (i >=0 && j>=0){
            if(s[i] >= g[j]){
                count ++ ;
                i--;
                j--;
            }else {
                j--;
            }
        }
        return count;
    }

    /**
     * leetcode:392
     *
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     *
     * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
     *
     * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/is-subsequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        while (i>=0 && j>=0){
            if(s.charAt(i) == t.charAt(j)){
                i--;
                j--;
            }else {
                j --;
            }
        }
        if(i < 0){
            return true;
        }
        return false;
    }

    /**
     * leetcode:435
     *
     * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
     *
     * 注意:
     *
     * 可以认为区间的终点总是大于它的起点。
     * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
     * 示例 1:
     *
     * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
     *
     * 输出: 1
     *
     * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/non-overlapping-intervals
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int i = 0;
        int j = 1;
        int count = 0;
        while (j<intervals.length){
            if(intervals[i][1] >intervals[j][0]){
                count ++;
            }else{
                i = j;
            }
            j++;
        }
        return count;
    }
}
