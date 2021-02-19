package com.dyl.sort.popular;

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
     * 单链表反转  递归排序
     */
    public static Node sort3(Node node){
//        if(node == null || node.next == null){
//            return node;
//        }
//        Node result = sort3(node.next);
//        node.next.next = node;
//        node.next = null;
//        return result;

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
//        Node pre = null;
//        Node next = null;
//        while (node != null){
//            next = node.next;
//            node.next = pre;
//            pre = node;
//            node = next;
//        }
//        return pre;

        Node pre = null;
        Node next = null;
        while (node != null){
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }


    public static Node sort3_(Node node){
        if(node == null || node.next == null){
            return node;
        }
        Node result = sort3_(node.next);
        node.next.next = node;
        node.next = null;
        return result;
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


    public static String sort4_(String str){
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
            middle = low + (high - low)/2; //防止溢出
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


    public static int sort4_(int[] array,int num){
        int low = 0;
        int high = array.length - 1;
        int middle ;
        while(low<=high){
            middle = (low + high)/2;
            if(array[middle] < num){
                high = middle - 1;
            }else if(array[middle]>num) {
                low = middle + 1;
            }else {
                return middle;
            }
        }
        return  -1;
    }

    /**
     * 无序数组a，求a[i]-a[j]的最大值，且i<j
     * @param array
     */
    public static int sort5(int[] array){
//        int max = Integer.MIN_VALUE;
//        int minArry = array[array.length - 1];
//        int temp;
//        for(int i = array.length - 2 ;i>=0;i--){
//            temp = array[i] - minArry;
//            if(array[i] <  minArry){
//                minArry = array[i];
//            }
//            if(temp > max){
//                max = temp;
//            }
//        }
//        return max;
        int max = Integer.MIN_VALUE;
        int minArray = array[array.length - 1];
        for(int i = array.length - 2 ; i>=0;i--){
            max = Math.max(max,array[i] - minArray);
            minArray = Math.min(minArray,array[i]);
        }
        return max;
    }


    public static int sort5_(int[] array){
        int result = Integer.MIN_VALUE;
        int minArray = array[array.length-1];
        int temp;
        for(int j = array.length - 2;j>=0;j--){
            temp = array[j] - minArray;
            if(array[j] >minArray){
                minArray = array[j];
            }
            if(temp > result){
                result = temp;
            }
        }
        return result;
    }


    /**
     *给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     */
    public static void sort6(int[] array){
        int lastIndex = 0;
        int temp;
        for(int i = 0;i<array.length;i++){
            if(array[i]!=0 && lastIndex != i){
                temp = array[i];
                array[i] = array[lastIndex];
                array[lastIndex++] = temp;
            }
        }
    }

    public static void sort6_(int[] array){
        int lastIndex = 0;
        int temp;
        for(int i = 0;i<array.length;i++){
            if(array[i] != 0){
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
//        int lastIndex = 0;
//        for(int i = 1;i<array.length;i++){
//            if(array[lastIndex]!=array[i]){
//                array[++lastIndex] = array[i];
//            }
//        }
//        return lastIndex + 1;

        int lastIndex = 0;
        for(int i = 1;i<array.length - 1 ; i++){
            if(array[i]!=array[lastIndex]){
                array[++lastIndex] =  array[i];
            }
        }
        return lastIndex + 1;
    }


    public static int sort7_(int[] array){
        int lastIndex = 0;
        for(int i = 1;i<array.length;i++){
            if(array[lastIndex] != array[i]){
                array[++lastIndex] = array[i];
            }
        }
        return lastIndex+1;
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

    public static int[] sort10_(int[] a,int[] b){
        int[] result = new int[a.length + b.length];
        int i = 0,j = 0,k = 0 ;
        while (i<a.length&&j<b.length){
            if(a[i]<b[j]){
                result[k++] = a[i++];
            }else {
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

    /**
     *判断链表是否是一个环
     * @param node
     */
    public boolean sort10(Node node){
//        if(node == null){
////            return false;
////        }
////        Node fast = node.next;
////        Node slow = node;
////        while (fast !=null && fast.next!=null){
////            fast = fast.next.next;
////            slow = slow.next;
////            if(fast == slow){
////                return true;
////            }
////        }
////        return false;

        if(node == null || node.next == null){
            return false;
        }

        Node slow = node;
        Node fast = node.next;
        while (node != null && node.next != null){
            slow = node.next;
            fast = node.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }


    public static boolean sort10_(Node node){
        if(node == null){
            return false;
        }
        Node fast = node.next;
        Node slow = node;
        while (fast != null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }


    /**
     * 两个有序的链表合并
     * @param n1
     * @param n2
     * @return
     */
    public static Node sort11(Node n1,Node n2){
        Node solder = new Node(0);
        Node p = solder;
        while (n1 != null && n2 !=null){
            if(n1.value < n2.value){
                p.next = n1;
                n1 = n1.next;
            }else{
                p.next = n2;
                n2 = n2.next;
            }
            p = p.next;
        }
        if(n1 != null){
            p.next = n1;
        }
        if(n2 != null){
            p.next = n2;
        }
        return solder.next;
    }

    /**
     * 删除倒数第K个结点
     * @return
     */
    public static Node sort12(Node list,int k){
        int i = 1;
        Node fast = list;
        while (fast != null && i<k){
            fast = fast.next;
            i++;
        }
        if(fast == null){
            return list;
        }
        Node slow = list;
        Node pre = null;
        while(fast.next != null){
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }
        if(pre == null){
            list = list.next;
        }else{
            pre.next = pre.next.next;
        }
        return list;

    }

    /**
     *求中间结点
     * @param list
     * @return
     */
    public static Node sort13(Node list){
        if(list == null){
            return null;
        }
        Node fast = list;
        Node slow = list;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;

    }

    /**
     * 判断一个链表是否是回文链表
     * @return
     */
    public static boolean sort14(Node node){
        if(node == null){
            return false;
        }
        if(node.next == null){
            return true;
        }
        Node fast = node;
        Node slow = node;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        display(node);
        Node other = slow.next;
        slow.next = null;

        Node pre = null;
        Node next = null;
        while (other != null){
            next = other.next;
            other.next = pre;
            pre = other;
            other = next;
        }
        Node compareleft = node;
        Node compareRight = pre;
        boolean flag = true;
        while (compareRight != null){
            if(compareleft.value != compareRight.value){
                flag = false;
            }
            compareleft = compareleft.next;
            compareRight = compareRight.next;
        }

        Node right = null;
        Node rightNext = null;
        while (pre != null){
            rightNext = pre.next;
            pre.next = right;
            right = pre;
            pre = rightNext;
        }
        slow.next = right;
        display(node);
        return flag;
    }

    public static void display(Node node){
        while (node != null){
            System.out.print(node.value + " -> ");
            node = node.next;
        }
        System.out.println();
    }

    @Test
    public void testSort14(){
        Node node = new Node(1);
        node.next = new Node(2);

        node.next.next = new Node(2);
        node.next.next.next = new Node(1);
        boolean b = sort14(node);
        System.out.println(b);
    }


    /**
     * a，b两个字符串，删除a种包含的b，如  a = "aabb" b = "ab" ,result = "";
     * @return
     */
    public static String sort15(String a,String b){

        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        int lastIndex = 0;
        int i = 0;
        int temp;
        while (i<aChars.length){
            temp = lastIndex;
            aChars[lastIndex ++ ] = aChars[i];
            if(aChars[i] != bChars[0]){
                i++;
                continue;
            }
            boolean flag = false;
            for(int j = 1;j<bChars.length;j++){
                char temp1 = aChars[i+j];
                aChars[lastIndex ++] = temp1;
                if(temp1 != bChars[j]){
                    flag = true;
                    break;
                }
            }
            if(flag) {
                lastIndex = temp;
            }
        }
        if (lastIndex == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for(int z = 0 ;z<lastIndex;z++){
            result.append(aChars[z]);
        }
        return result.toString();
    }

    @Test
    public void testSort15(){
        String a = "aabb";
        String b = "ab";
        String s = sort15(a, b);
        System.out.println(s);
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

       public Integer getValue(){
           return value;
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

