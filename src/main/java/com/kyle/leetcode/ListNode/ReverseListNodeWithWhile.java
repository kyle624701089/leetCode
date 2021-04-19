package com.kyle.leetcode.ListNode;

/**
 * @author sunkai-019
 * @title: ReverseListNodeWithWhile
 * @projectName leetcode
 * @description: 通过遍历反转链表
 * @date 2021/4/19 20:43
 */
public class ReverseListNodeWithWhile {

    static class ListNode{
        int value;
        ListNode next;

        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 假设原始链表： 1--->2--->3--->4--->5
     * 需要反转成：5--->4--->3--->2--->1
     */

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5, null);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        ListNode reversedListNode = reverseListNode(listNode1);
        System.out.println(reversedListNode);

    }

    private static ListNode reverseListNode(ListNode head) throws IllegalArgumentException {
        if (head == null) {
            throw new IllegalArgumentException("不存在链表");
        }
        /**
         * 解题思路：
         * 1、先将当前节点的下一个节点c保存到临时变量next中；
         * 2、因为当前节点的下个节点反转后将变成当前节点的前一个节点，所以也用prev临时变量保存下一个节点；
         * 3、前后两个节点都用临时变量保存后，c开始往后面移动，当前节点变成了下一个节点prev=c,c=next；
         */
        ListNode prev = null, next;
        ListNode c = head;
        //跳出循环的出口是当前节点为空
        while (c != null) {
            next = c.next;
            c.next = prev;
//            这里需要先将c赋值给prev，否则会丢失当前节点，返回null
            prev = c;
            c = next;
        }
        return prev;
    }



}
