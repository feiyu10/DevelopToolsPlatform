package com.hezhenguang.developtoolsplatform.study.test;

/**
 * 系统版本: v1.0<br>
 *
 * @description:
 * @author: hezg26906@hundsun.com<br>
 * @date: 2022-11-24
 **/
public class FuTuTest {


    /**
     * 输入: 1->8->3->6->5->4->7->2->NULL
     * 输出: 1->2->3->4->5->6->7->8->NULL
     */
    static class Node {
        int val;
        Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }


    public static Node sort(Node head) {
        Node[] node = partition(head);
        node[1] = reverseNode(node[1]);
        return merge(node[0], node[1]);
    }

    private static Node merge(Node odd, Node even) {
        Node ans = new Node();
        Node res = ans;
        while (odd != null && even != null) {
            if (odd.val <= even.val) {
                res.next = odd;
                odd = odd.next;
            } else {
                res.next = even;
                even = even.next;
            }
            res = res.next;
        }
        while (odd != null) {
            res.next = odd;
            odd = odd.next;
            res = res.next;
        }
        while (even != null) {
            res.next = even;
            even = even.next;
            res = res.next;
        }
        return ans.next;
    }

    /**
     * 反转
     *
     * @param node
     */
    private static Node reverseNode(Node node) {
        Node p = node;
        Node pre = null;
        while (p != null) {
            Node next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;
    }

    public static Node[] partition(Node head) {
        // 分奇偶
        Node odd = head;
        Node evenHead = head.next;
        // p移动
        Node p = evenHead;
        while (p != null && p.next != null) {
            odd.next = p.next;
            odd = odd.next;
            p.next = odd.next;
            p = p.next;
        }
        odd.next = null;
        Node[] list = new Node[]{head, evenHead};
        return list;
    }


    public static void main(String[] args) {
        Node head = init();
        Node res = sort(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static Node init() {
        Node node1 = new Node(1);
        Node node2 = new Node(8);
        Node node3 = new Node(3);
        Node node4 = new Node(6);
        Node node5 = new Node(5);
        Node node6 = new Node(4);
        Node node7 = new Node(7);
        Node node8 = new Node(2);
        Node node9 = new Node(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        return node1;
    }

}
