package com.dyl.mianshi.sort;

import com.alibaba.fastjson.JSONArray;
import lombok.Data;
import org.junit.Test;

import java.util.Arrays;

/**
 * 主要用来实现基本的算法面试题，用于复习
 * @author dongyuliang
 * @date 2020-03-27 15:33
 */
public class BaseSort {


    /**
     * 从数组里找10个最大的数，我只想到排序后再找，没想到其他方法
     */
    public void sort1(){

    }


    /**
     * 两个链表是否有相交。
     */
    public void sort2(){

    }


    /**
     * 单链表反转  递归排序
     */
    public static Node sort3(Node node){
        if(node == null || node.next == null){
            return node;
        }
        Node result = sort3(node.next);
        node.next.next = node;
        node.next = null;
        return result;
    }

    /**
     * 单链表反转 正序排
     * @param node
     * @return
     */
    public static Node sort3_3(Node node){
        Node pre = null;
        Node next = null;
        while (node!=null){
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

    /**
     * 字符串反转
     * @return
     */
    public static String sort4(String str){
        if(str == null || str.length() == 0 || str.length() == 1){
            return str;
        }
        return sort4(str.substring(1))+str.charAt(0);
    }


    /**
     * 二分法查找
     * @param arry
     * @param num
     * @return
     */
    public static int sort4(int[] arry,int num){
        int low = 0;
        int high = arry.length - 1;
        int middle = 0;
        while (low <= high){
            middle = (low + high)/2;
            if(arry[middle] < num){
                low = middle + 1;
            }else if(arry[middle] >num){
                high = middle -1;
            }else{
                return middle;
            }
        }
        return -1;

    }

    /**
     * 无序数组a，求a[i]-a[j]的最大值，且i<j
     * @param array
     */
    public static int sort5(int[] array){
        int max = Integer.MIN_VALUE;
        int minArry = array[array.length - 1];
        int temp;
        for(int i = array.length - 2 ;i>=0;i--){
            temp = array[i] - minArry;
            if(array[i] <  minArry){
                minArry = array[i];
            }
            if(temp > max){
                max = temp;
            }
        }
        return max;
    }


    /**
     *给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     */
    public static void sort6(int[] array){
        int lastIndex = 0;
        int temp;
        for(int i = 0;i<array.length;i++){
            if(array[i]!=0){
                temp = array[i];
                array[i] = array[lastIndex];
                array[lastIndex++] = temp;
            }
        }
    }

    @Test
    public void testSort6(){
        int[] array = {1,0,0,3,5,7,0};
        sort6(array);
        System.out.println(JSONArray.toJSON(array));
    }


    /**
     * 2. 删除排序数组中的重复项
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度
     * @param array
     * @return
     *
     * 使用双指针的解题思路
     * 将不重复的统一到数组的一段即可
     *
     * leetCode:
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/shan-chu-pai-xu-shu-zu-zhong-de-zhong-fu-xiang-by-/
     */
    public static int sort7(int[] array){
        int lastIndex = 0;
        for(int i = 1;i<array.length;i++){
            if(array[lastIndex]!=array[i]){
                array[++lastIndex] = array[i];
            }
        }
        return lastIndex + 1;
    }

    @Test
    public void testSort7(){
        int[] array = {1,1,2,2,3,3,4,4,5,6,7,8};
        int count = sort7(array);
        for(int i = 0;i<count;i++){
            System.out.println(array[i]);
        }
    }


    /**
     * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度
     *
     * @param array
     * @param value
     * @return
     */
    public static int sort8(int[] array,int value){
        int lastIndex = 0;
        for(int i = 0;i<array.length;i++){
            if(array[i]!=value){
                array[lastIndex++] = array[i];
            }
        }
        return lastIndex +1;
    }

    @Test
    public void testSort8(){
        int[] array = {1,9,8,3,5,7,8,9,8,2,3,4,5};
        int count = sort8(array,8);
        for(int i = 0;i<count;i++){
            System.out.println(array[i]);
        }

    }

    /**
     * 两个有序数组合并成一个有序数组
     * @param a
     * @param b
     * @return
     */
    public static int[] sort10(int[] a,int[] b){
        int[] result = new int[a.length+b.length];
        int i = 0,j = 0,k = 0;
        while(i<a.length&&j<b.length){
            if(a[i]<b[j]){
                result[k++] = a[i++];
            }else{
                result[k++] = b[j++];
            }
        }
        while (i<a.length){
            result[k++] = a[i++];
        }
        while (j<b.length){
            result[k++] = b[j++];
        }
        return result;
    }

    @Test
    public void testSort10(){
        int[] a = {1,2,3,4,5,6};
        int[] b = {2,4,6,8,10};
        int[] ints = sort10(a, b);
        System.out.println(JSONArray.toJSON(ints));
    }

    public static void test11(int[] a ,int n, int[] b, int m){

    }

    @Test
    public void testSort5(){
        int[] a = new int[] { 9, 20, 3, 16, 6, 5, 7, 1 };
        System.out.println("a[" + a.length + "]=" + Arrays.toString(a));
        System.out.println("find max of a[i]-a[j],i<j : " + sort5(a));
    }

    public static void testSort4(){
        int[] a = {1,3,4,6,7,9,12,45,67,98,110};
        System.out.println(sort4(a, 8));
    }



    @Data
    static class Node{
       public Node next;

       public Integer value;

       public Node(Integer value){
           this.value = value;
       }
    }

    public static void main(String[] args) {
//        String str = "hello";
//        System.out.println(sort4(str));
//        testSort3();
//        testSort3_3();
        testSort4();

    }



    public static void testSort3() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        Node testNode1 = node1;
        while (testNode1 != null) {
            System.out.print(testNode1.getValue() + "->");
            testNode1 = testNode1.next;
        }
        System.out.println();
        System.out.println("递归方法");
        Node testNode2 = sort3(node1);
        while (testNode2 != null) {
            System.out.print(testNode2.getValue() + "->");
            testNode2 = testNode2.next;
        }
        System.out.println();
    }

        public static void testSort3_3(){
            Node node1 = new Node(1);
            Node node2 = new Node(2);
            Node node3 = new Node(3);
            Node node4 = new Node(4);
            node1.next = node2;
            node2.next = node3;
            node3.next = node4;
            System.out.println("正序遍历");
            Node testNode3 = sort3_3(node1);
            while (testNode3 != null){
                System.out.print(testNode3.getValue()+"->");
                testNode3 = testNode3.next;
            }
            System.out.println();
        }

    }

