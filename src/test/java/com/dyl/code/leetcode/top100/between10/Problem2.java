package com.dyl.code.leetcode.top100.between10;

/**
 * @Classname Problem1
 * @Description 题目 2
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 31.1.21 8:46 下午
 * @Created by dongyuliang
 */
public class Problem2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dump = new ListNode(0);
        ListNode cur = dump;
        ListNode list1 = l1;
        ListNode list2 = l2;
        int mid = 0;
        while (list1 != null || list2 != null){

            int num1 = 0;
            int num2 = 0;
            if(list1 != null){
                num1 = list1.val;
                list1 = list1.next;
            }

            if(list2 != null){
                num2 = list2.val;
                list2 = list2.next;
            }

            int result = num1 + num2 + mid;
            if(result/10 > 0){
                mid = 1;
            }else {
                mid = 0;
            }
            ListNode node = new ListNode(result & 10);
            cur.next = node;
            cur = node;
            list1 = list1.next;
            list2 = list2.next;
        }

        if(mid > 0){
            cur.next = new ListNode(1);
        }
        return dump.next;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
