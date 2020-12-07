package com.dyl.code.leetcode.linked;


/**
 * @Classname LinkedNode
 * @Date 5.12.20 5:20 下午
 * @Created by dongyuliang
 */
public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    /**
     * 92
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dump = new ListNode(0);
        dump.next = head;
        ListNode before = dump;
        for (int i = 0 ; i< m;i++){
            before = before.next;
        }
        ListNode cur = before.next;
        ListNode pre = null;
        for(int i = m ;i<n;i++){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        before.next.next = cur;
        before.next = pre;
        return dump.next;
    }

    /**
     * 83
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode cur = head;
        while (cur.next != null){
            if(cur.val == cur.next.val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head;
    }


    /**
     * 86
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode before = new ListNode(0);
        ListNode after = new ListNode(0);
        ListNode beforeCur = before;
        ListNode afterCur = after;
        while (head != null){
            if(head.val <x){
                beforeCur.next = head;
                beforeCur = head;
            }else {
                afterCur.next = head;
                afterCur = head;
            }
            head = head.next;
        }
        afterCur.next = null;
        beforeCur.next = after.next;
        return before.next;
    }

    /**
     * 328
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        ListNode before = new ListNode(0);
        ListNode after = new ListNode(0);
        ListNode beforeCur = before;
        ListNode afterCur = after;
        int i = 1;
        while (head != null){
            if(i%2 != 0){
                beforeCur.next = head;
                beforeCur = head;
            }else {
                afterCur.next = head;
                afterCur = head;
            }
            head = head.next;
            i ++;
        }
        afterCur.next = null;
        beforeCur.next = after.next;
        return before.next;
    }

    /**
     * 2
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dump = new ListNode(0);
        ListNode cur = dump;
        int flag = 0;
        while (l1 != null || l2 != null){
            int num1 = 0;
            int num2 = 0;
            if(l1 != null){
                num1 = l1.val;
                l1 = l1.next;
            }

            if(l2 != null){
                num2 = l2.val;
                l2 = l2.next;
            }

            int sum = num1 + num2 + flag;
            if(sum >= 10){
                flag = 1;
                cur.next = new ListNode(sum%10);
            }else {
                flag = 0;
                cur.next = new ListNode(sum);
            }
            cur = cur.next;
        }

        if(flag == 1){
            cur.next = new ListNode(1);
        }
        return dump.next;
    }
}
