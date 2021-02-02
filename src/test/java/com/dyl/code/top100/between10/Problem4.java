package com.dyl.code.top100.between10;

/**
 * @Classname Problem4
 * @Description 求两个有序数组的中位数
 * @Date 28.1.21 5:46 下午
 * @Created by dongyuliang
 */
public class Problem4 {

    /**
     * 通过二分查找法
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int left = 0;
        int right = m;
        int totalLeft = (m + n + 1)/2;
        while (left < right){
            int i = (right + left + 1) / 2;
            int j = totalLeft - i;
            if(nums1[i - 1] > nums2[j]){
                right = i - 1;
            }else {
                left = i ;
            }
        }
        int i = left;
        int j = totalLeft - i;

        int nums1Left = i == 0?Integer.MIN_VALUE:nums1[i - 1];
        int nums1right = i == m ? Integer.MAX_VALUE:nums1[i];
        int nums2Left = j == 0 ? Integer.MIN_VALUE:nums2[j-1];
        int num2Right = j == n ? Integer.MAX_VALUE:nums2[j];

        if((m + n)%2 == 1){
            return Math.max(nums1Left,nums2Left);
        }else {
            return (Math.max(nums1Left,nums2Left) + Math.min(nums1right,num2Right))/2.0;
        }

    }


    public static void main(String[] args) {
        Problem4 problem4 = new Problem4();
        int[] a = {1,3};
        int[] b = {2,7};

        System.out.println(problem4.findMedianSortedArrays(a,b));
    }


}
