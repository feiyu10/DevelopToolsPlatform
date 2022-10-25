package com.hezhenguang.developtoolsplatform.study.菜鸟;

/**
 * 系统版本: v1.0<br>
 *
 * @description:
 * @author: hezg26906@hundsun.com<br>
 * @date: 2022-10-25
 **/
public class MergeTwoLists {

    /**
     * 合并链表
     * 已知两个链表head1 和head2 各自从小到大有序，请把它们归并成一个链表依然从小到大有序
     */


    class Node{
        int data;
        Node next;
    }

    Node Merge(Node head1 , Node head2) {
        if (head1 == null || head1 == null){
            return null;
        }
        if (head1 == null){
            return head2;
        }
        if (head2 == null){
            return head1;
        }

        Node result = new Node();
        result.data = -1;
        Node temp = result;
        while (head1 != null && head2 != null){

            if (head1.equals(head2) == true){
                System.out.println("链表节点相交!");
                break;
            }
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
            }else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        temp.next = (head1 == null) ? head2 : head1;
        return result.next;
    }


}
