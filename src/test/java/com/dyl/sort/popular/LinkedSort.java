package com.dyl.sort.popular;


import org.junit.Test;

import java.util.Stack;

/**
 * 链表常见的算法题
 */
public class LinkedSort {

    /**
     * 反向打印链表
     * 1、通过递归的方式，打印本节点之前先打印后面的节点，依次递归
     * 2、通过 stack先进后去的特性，打印
     */
    /**
     * 递归方式打印
     */
    public void reservePrint(ListNode node){
        if(node == null){
            return;
        }
        reservePrint(node.next);
        System.out.println(node.val);
    }

    public void reservePrintStack(ListNode node){
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = node;
        while (temp != null){
            stack.push(temp);
            temp = temp.next;
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop().val);
        }
    }

    @Test
    public void testReservePrint(){
        reservePrintStack(initNode());
    }

    /**
     * 以O(1)的方式删除链表的一个节点
     * @param current
     * @param head
     */
    public void deleteNode(ListNode current, ListNode head){
        if(head == null || current == null){
            return;
        }
        if(current.next !=null){
            current.val = current.next.val;
            current.next = current.next.next;
        }else if(current == head){
            head = null;
            current = null;
        }else{
            ListNode temp = head;
            while (temp.next != current){
                temp = temp.next;
            }
            temp.next = null;
        }
    }

    /**
     * 获取倒数第K个节点
     */
    public ListNode getReverseK(ListNode node, int n){
        ListNode pre = node;
        int i = 1;
        while (i<n && pre != null){
            pre = pre.next;
            i++;
        }
        if(pre == null){
            return null;
        }
        ListNode slow = node;
        while (pre.next != null){
            pre = pre.next;
            slow = slow.next;
        }
        return slow;
    }

    @Test
    public void testGetReserveK(){
        ListNode node = initNode();
        int n = 4;
        ListNode result ;
        result = getReverseK(node,n);
        if(result == null){
            System.out.println("结果为空");
        }else {
            System.out.println("倒数第" + n + "个节点的值：" +result.val);
        }
         n = 6;
        result = getReverseK(node,n);
        if(result == null){
            System.out.println("结果为空");
        }else {
            System.out.println("倒数第" + n + "个节点的值：" +result.val);
        }
    }


    /**
     * 翻转链表的方式
     * 1、递归
     * 2、迭代
     * 3、通过栈的方式
     * @return
     */

    /**
     * 通过递归的方式
     */
    public ListNode reserveRecurrence(ListNode node){
        if(node == null || node.next == null){
            return node;
        }
        ListNode result = reserveRecurrence(node.next);
        node.next.next = node;
        node.next = null;
        return result;
    }

    /**
     * 迭代的方式翻转
     * @param node
     * @return
     */
    public ListNode reserveIteration(ListNode node){
        ListNode pre = null;
        ListNode next = null;
        while (node != null){
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

    /**
     * 通过Stack反转
     * @param node
     * @return
     */
    public ListNode reserveStack(ListNode node){
        Stack<ListNode> stack = new Stack<>();
        while (node != null){
            stack.push(node);
            node = node.next;
        }
        ListNode sentry = new ListNode(0);
        ListNode current = sentry;
        while (!stack.isEmpty()){
            current.next = stack.pop();
            current = current.next;
        }
        current.next = null;
        return sentry.next;
    }

    @Test
    public void testReserve(){
        ListNode node1 = initNode();
        ListNode node2 = initNode();
        ListNode node3 = initNode();

        ListNode node1_1 = reserveRecurrence(node1);
        System.out.println("递归反转结果");
        printNode(node1_1);

        ListNode node2_2 = reserveIteration(node2);
        System.out.println("迭代反转结果");
        printNode(node2_2);

        ListNode node3_3 = reserveStack(node3);
        System.out.println("stack反转结果");
        printNode(node3_3);

    }

    /**
     * 合并两个有序链表
     * @param node1
     * @param node2
     */
    public ListNode merge(ListNode node1, ListNode node2){
        ListNode sentry = new ListNode(0);
        ListNode current1 = node1;
        ListNode current2 = node2;
        ListNode currentSentry = sentry;
        while (current1 != null && current2 !=null){
            if(current1.val <= current2.val){
                currentSentry.next = current1;
                current1 = current1.next;
            }else {
                currentSentry.next = current2;
                current2 = current2.next;
            }
            currentSentry = currentSentry.next;
        }
       if(current1 != null){
            currentSentry.next = current1;
        }else{
           currentSentry.next = current2;
       }
        return sentry.next;
    }

    @Test
    public void testMerge(){
        ListNode node1 = initNode();
        ListNode node2 = initNode2();
        ListNode merge = merge(node1, node2);
        printNode(merge);
    }

    /**
     * leetcode的第92题
     * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
     *
     * 说明:
     * 1 ≤ m ≤ n ≤ 链表长度。
     *
     * 示例:
     *
     * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
     * 输出: 1->4->3->2->5->NULL
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param node
     * @param m
     * @param n
     */
    public ListNode reserve2(ListNode node, int m, int n){
        //构建一个哨兵，头结点边界问题不需要判断
        ListNode sentinel = new ListNode(0);
        sentinel.next = node;
        ListNode newNode = sentinel;
        int i = 1;
        while (i < m){
            newNode = newNode.next;
            i++;
        }
        //newNode 代表开始反转节点的上一个节点
        //beginNode 代表开始反转的节点
        ListNode beginNode = newNode.next;
        ListNode pre = null;
        ListNode next = null;
        while (i <= n){
            next = beginNode.next;
            beginNode.next = pre;
            pre = beginNode;
            beginNode = next;
            i++;
        }
        //pre代表反转后的节点，
        //newNode的next节点此时已经在最后面，需要在执行反转结束后的节点
        newNode.next.next = next;
        //newNode 的下一个节点只想反转后的节点
        newNode.next = pre;
        return sentinel.next;
    }

    /**
     * 83. 删除排序链表中的重复元素
     *
     * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode cur = head;
        while (cur.next !=null){
            if(cur.val == cur.next.val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return head;
    }

    /**
     * 86. 分隔链表
     *
     * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
     *
     * 你应当保留两个分区中每个节点的初始相对位置。
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head,int x){
        ListNode before = new ListNode(0);
        ListNode beforeNode = before;
        ListNode after = new ListNode(0);
        ListNode afterNode = after;
        while (head != null){
            if(head.val < x){
                beforeNode.next = head;
                beforeNode = beforeNode.next;
            }else {
                afterNode.next = head;
                afterNode = afterNode.next;
            }
            head = head.next;
        }
        beforeNode.next = after.next;
        afterNode.next = null;
        return before.next;
    }

    /**
     * 2. 两数相加
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode dummyHead = new ListNode(0);
//        ListNode cur = dummyHead;
//        ListNode p = l1;
//        ListNode q = l2;
//        int temp = 0; int pVal,qVal,sum;
//        while (p != null || q != null){
//            pVal = p != null ? p.val:0;
//            qVal = q != null ? q.val:0;
//            sum = pVal + qVal + temp;
//            temp = sum/10;
//            sum = sum%10;
//            cur.next = new ListNode(sum);
//            cur = cur.next;
//            if(p != null) p = p.next;
//            if(q != null) q = q.next;
//        }
//        if(temp == 1){
//            cur.next = new ListNode(1);
//        }
//        return dummyHead.next;

        ListNode dumpHead = new ListNode(0);
        ListNode cur = dumpHead;
        ListNode p1 = l1;
        ListNode p2 = l2;
        int pre = 0;
        int p1Val,p2Val,sum;
        while (p1 != null ||p2 !=null){
            p1Val = p1 == null ? 0:p1.val;
            p2Val = p2 == null ? 0:p2.val;
            sum = p1Val + p2Val + pre;
            pre = sum/10;
            cur.next =  new  ListNode(sum%10);
            cur = cur.next;
            p1 = p1.next == null? p1:p1.next;
            p2 = p1.next == null? p2:p2.next;
        }
        if(pre == 1){
            cur.next = new ListNode(1);
        }
        return dumpHead.next;
    }


    /**
     * 两数相加 II
     *
     *给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
     *你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<ListNode> l1Stack = new Stack<>();
        Stack<ListNode> l2Stack = new Stack<>();
        Stack<ListNode> result = new Stack<>();
        while (l1 != null){
            l1Stack.push(l1);
            l1 = l1.next;
        }
        while (l2 !=null){
            l2Stack.push(l2);
            l2 = l2.next;
        }
        int carry = 0;int l1Val,l2Val,sum;
        while (!l1Stack.isEmpty() || !l2Stack.isEmpty()){
            l1Val = l1Stack.isEmpty() ? 0:l1Stack.pop().val;
            l2Val = l2Stack.isEmpty() ? 0 :l2Stack.pop().val;
            sum = carry + l1Val + l2Val;
            carry = sum/10;
            result.push(new ListNode(sum%10));
        }
        if(carry == 1){
            result.push(new ListNode(1));
        }
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (!result.isEmpty()){
            cur.next = result.pop();
            cur = cur.next;
        }
        return dummyHead.next;
    }

    /**
     * 82. 删除排序链表中的重复元素 II
     * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
//        ListNode dummyHead = new ListNode(0);
//        dummyHead.next = head;
//        ListNode cur = dummyHead;
//        ListNode temp;
//        while (cur.next != null && cur.next.next != null){
//            if(cur.next.val == cur.next.next.val){
//                temp = cur.next.next;
//                while (temp != null && temp.next !=null && temp.val == temp.next.val ){
//                    temp = temp.next;
//                }
//                cur.next= temp.next;
//            }else {
//                cur = cur.next;
//            }
//        }
//        return dummyHead.next;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp;
        ListNode cur = dummyHead;
        while (cur.next !=null && cur.next.next != null){
            if(cur.next.val == cur.next.next.val){
                temp = cur.next.next;
                while (temp != null && temp.next != null && temp.val == temp.next.val){
                       temp = temp.next;
                }
                cur = temp.next;
            }else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }






    public void printNode(ListNode node){
        while (node != null){
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println();
    }



    public ListNode initNode(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next =  new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        return head;
    }


    public ListNode initNode2(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next =  new ListNode(7);
        head.next.next.next.next = new ListNode(8);
        return head;
    }
    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }
}
