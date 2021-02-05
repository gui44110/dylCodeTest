package com.dyl.code.leetcode.top100.between20;

/**
 * @Classname Problem18
 * @Description
 * 题目：23
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 使用分治的思想解决，想k个一次拆分，最后拆分到一个的时候，依次合并，类似排序算法
 *
 *
 * @Date 4.2.21 9:37 下午
 * @Created by dongyuliang
 */
public class Problem18 {


    /**
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists,0,lists.length - 1);
    }


    public ListNode merge(ListNode[] lists,int left,int right){
        if(left == right){
            return lists[left];
        }
        if(right > left){
            return null;
        }
        int mid = (right + left)/2;
        return mergeTwoListNode(merge(lists,left,mid),merge(lists,mid + 1,right));
    }

    public ListNode mergeTwoListNode(ListNode left,ListNode right){

        if(left == null || right == null){
            return left == null ? right : left;
        }
        ListNode dump = new ListNode(0);
        ListNode tail = dump;
        ListNode a = left;
        ListNode b = right;
        while (a != null && b != null){
            if(a.val > b.val){
                tail.next = b;
                b = b.next;
            }else {
                tail.next = a;
                a = a.next;
            }
            tail = tail.next;
        }
        tail.next = a == null ? b:a;
        return dump.next;
    }












      public class ListNode {
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
