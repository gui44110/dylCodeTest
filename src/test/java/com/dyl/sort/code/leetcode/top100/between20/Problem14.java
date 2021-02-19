package com.dyl.sort.code.leetcode.top100.between20;


/**
 * @Classname Problem14
 * @Description
 * 题目：19
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * @Date 3.2.21 6:12 下午
 * @Created by dongyuliang
 */
public class Problem14 {






        public ListNode removeNthFromEnd(ListNode head, int n) {
            int i = 0;
            ListNode dump = new ListNode(0);
            dump.next = head;
            ListNode right = dump;
            ListNode pre = dump;

            while (i <= n){
                right = right.next;
                i++;
            }
            if(i < n){
                return dump.next;
            }
            while (right != null){
                pre = pre.next;
                right = right.next;
            }
            pre.next = pre.next.next;
            return dump.next;
        }



        class ListNode {
            int val;
            ListNode next;

            ListNode() {
            }

            ListNode(int val) {
                this.val = val;
            }

            ListNode(int val, ListNode next) {
                this.val = val;
                this.next = next;
            }
        }

}
