package org.practice.dsa.linkedlist;

public class DoublyLinkedList {

    Node head;

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;
    }


    public void display() {
        Node node = head;
        Node last = null;

        while (node != null) {
            System.out.print(node.val + "->");
            last = node;
            node = node.next;
        }
        System.out.println("END");
    }

    private class Node {
        int val;
        Node prev;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
}
