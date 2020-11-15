package com.dyl.code.leetcode.tanxin;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname ArrayProblem
 * @Date 29.10.20 9:54 下午
 * @Created by dongyuliang
 */
public class ArrayProblem {

    /**
     * 283
     * https://leetcode-cn.com/problems/move-zeroes/
     *
     */
    public void moveZeroes(int[] nums) {
        int pre = 0;//使用单指针记录前面不为0的位置,一旦发现有非0，交换位置后指针+1
        for(int i = 0 ;i<nums.length;i++){
            if(nums[i]!=0){
                if(pre != i) {
                    int temp = nums[pre];
                    nums[pre] = nums[i];
                    nums[i] = temp;
                }
                pre++;
            }
        }
    }

    public int removeElement(int[] nums, int val) {
        int pre = 0;
        for(int i = 0 ;i<nums.length;i++){
            if(nums[i] != val){
                if(pre != i){
                    int temp = nums[pre];
                    nums[pre] = nums[i];
                    nums[i] = temp;
                }
                pre ++;
            }
        }
        return pre;
    }

    /**
     * 26
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int pre = 0;
        for(int i = 1 ;i<nums.length;i++){
            if(nums[i] != nums[pre]){
                nums[++pre] = nums[i];
            }
        }
        return pre + 1;
    }

    /**
     * 80
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
     * @param nums
     * @return
     */
    public int removeDuplicates1(int[] nums) {
        int pre = 0;
        int size = 1;
        for(int i = 1;i<nums.length;i++){
            if(nums[pre] != nums[i]){
                nums[++pre] = nums[i];
                size = 1;
            }else{
                if(size < 2){
                    size ++;
                    nums[++pre] = nums[i];
                }
            }
        }
        return pre + 1;
    }


    /**
     * 75
     *
     * https://leetcode-cn.com/problems/sort-colors/
     * @param nums 1,2,0
     */
    public void sortColors(int[] nums) {
        int left  = -1;
        int right = nums.length;
        int i = 0;
        while (i<right){
            if(nums[i] == 0){
                left ++;
                swap(nums,left,i);
                i++;
            }else if(nums[i] == 2) {
                right -- ;
                swap(nums,right,i);
            }else {
                i++;
            }

        }
    }

    public void swap(int nums[],int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    /**
     * 88
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m -1 ,j = n - 1,k = m + n -1;
        while (i >=0 && j>=0){
            if(nums1[i] > nums2[j]){
                nums1[k--] = nums1[i--];
            }else{
                nums1[k--] = nums2[j--];
            }
        }
        if(j >= 0){
            while (j>=0){
                nums1[k--]=nums2[j--];
            }
        }
    }

    /**
     * 215
     * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        while (true){
            int partition = partition(nums, left, right);
            if(partition == k - 1){
                return nums[partition];
            }else if(partition > k - 1){
                right = partition;
            }else {
                left = partition + 1;
            }
        }

    }

    public int partition(int[] nums,int left ,int right){
        int pivot = nums[left];
        int j = left;
        int i = left + 1;
        while (i <=right){
            if(nums[i] > pivot){
                j++;
                swap(nums,i,j);
            }
            i++;
        }
        swap(nums,j,left);
        return j;

    }

    @Test
    public void test1(){
        int[] a = {3,2,1,5,6,4};
        int kthLargest = findKthLargest(a, 2);
        System.out.println(kthLargest);
    }


    /**
     * N皇后问题
     * https://leetcode-cn.com/problemset/all/?search=%E5%85%AB%E7%9A%87%E5%90%8E
     */
    @Test
    public void solveNQueens() {
        List<List<String>> lists = solveNQueens(8);
        print8QueensResult(lists);

    }

    public List<List<String>> solveNQueens(int  n){
        List<List<String>> result = new ArrayList<>(n);
        int[] array = new int[n];
        Arrays.fill(array,-1);
        reduce(result,array,0,n);
        return result;
    }

    public void reduce(List<List<String>> result,int[] array,int row,int n){
        if(row == n){
            List<String> strings = arrayToList(array);
            result.add(strings);
            return;
        }
        for(int i = 0 ;i<n;i++){
            if(isOk(array,n,row,i)){
                array[row] = i;
                reduce(result,array,row+1,n);
            }
        }

    }

    public List<String> arrayToList(int[] array){
        List<String> result = new ArrayList<>(array.length);
        for(int i = 0;i<array.length;i++){
            StringBuilder stringBuilder = new StringBuilder();
            int i1 = array[i];
            for(int j = 0 ;j<array.length;j++){
                if(j == i1){
                    stringBuilder.append("Q");
                }else {
                    stringBuilder.append(".");
                }
            }
            result.add(stringBuilder.toString());
        }
        return result;
    }

    public boolean isOk(int[] array,int n,int row,int col){
        int left = col - 1,right = col + 1;
        for(int i = row - 1;i>=0;i--){
            if(array[i] == col) return false;
            if(left >= 0){
                if(array[i] == left){
                    return false;
                }
            }

            if(right <=n){
                if(array[i] == right){
                    return false;
                }
            }
            left --;right++;
        }
        return true;
    }

    public void print8QueensResult(List<List<String>> lists){
        for(List<String> list : lists){
            for(String str : list){
                System.out.println(str);
            }
            System.out.println("---------");
        }
    }



}
